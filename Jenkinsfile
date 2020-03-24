pipeline {
	agent {
		label 'migration'
	}
  
	tools {
		maven 'apache-maven-latest'
		jdk 'oracle-jdk8-latest'
	}
  
	environment {
		BUILD_KEY = (github.isPullRequest() ? CHANGE_TARGET : BRANCH_NAME).replaceFirst(/^v/, '')
		CAPELLA_PRODUCT_PATH = "${WORKSPACE}/capella/capella"
  	}
  
  	stages {
  	
		stage('Generate Target Platform') {
	    	steps {        
	        	script { 
		        	if(github.isPullRequest()){
		        	    github.buildStartedComment()
		        	}
		
		        	currentBuild.description = BUILD_KEY
		        	
		        	sh 'env'
		        	sh 'mvn clean verify -f releng/org.polarsys.capella.vp.requirements.target/pom.xml'
	       		}         
	     	}
	    }
	    
    	stage('Build and Package') {
      		steps {
      			script {
      				def customParams = github.isPullRequest() ? '-DSKIP_SONAR=true' : '-Psign'
      	    
      	    		sh "mvn -Djacoco.skip=true -DjavaDocPhase=none ${customParams} clean package -f pom.xml"
	       		}         
	     	}
	    }
    
		stage('Deploy to Nightly') {
      		steps {
				script {
		    		def deploymentDirName = 
		    			(github.isPullRequest() ? "${BUILD_KEY}-${BRANCH_NAME}-${BUILD_ID}" : "${BRANCH_NAME}-${BUILD_ID}")
		    			.replaceAll('/','-')		
					
					deployer.addonNightlyDropins("${WORKSPACE}/releng/org.polarsys.capella.vp.requirements.site/target/*-dropins-*.zip", deploymentDirName)
					deployer.addonNightlyUpdateSite("${WORKSPACE}/releng/org.polarsys.capella.vp.requirements.site/target/*-updateSite-*.zip", deploymentDirName)					

	       		}         
	     	}
	    }
	    
	    stage('Download Capella') {
    		when {
        		expression { 
        			github.isPullRequest() 
        		}
      		}
      		
        	steps {
        		script {
	        		def capellaURL = capella.getDownloadURL("${BUILD_KEY}", 'linux', '')
	        		
	        		sh "curl -k -o capella.zip ${capellaURL}"
					sh "unzip -q capella.zip"

	       		}         
	     	}
	    }

    	stage('Install test features') {
    		when {
        		expression { 
        			github.isPullRequest() 
        		}
      		}
      		
        	steps {
        		script {
	        		sh "chmod 755 ${CAPELLA_PRODUCT_PATH}"
	        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", 'http://download.eclipse.org/tools/orbit/downloads/drops/R20130827064939/repository', 'org.jsoup')	        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", capella.getTestUpdateSiteURL("${BUILD_KEY}"), 'org.polarsys.capella.test.feature.feature.group')
	        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", "file:/${WORKSPACE}/releng/org.polarsys.capella.vp.requirements.site/target/repository/".replace("\\", "/"), 'org.polarsys.capella.vp.requirements.feature.feature.group')
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", "file:/${WORKSPACE}/releng/org.polarsys.capella.vp.requirements.site/target/repository/".replace("\\", "/"), 'org.polarsys.capella.vp.requirements.tests.feature.feature.group')
	       		}         
	     	}
	    }
	    
    	stage('Run tests') {
    		when {
        		expression { 
        			github.isPullRequest() 
        		}
      		}
    	
        	steps {
        		script {
        			wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
		        		
		        		tester.runUITests("${CAPELLA_PRODUCT_PATH}", 'RequirementsTestSuite', 'org.polarsys.capella.vp.requirements.ju', 
		        			['org.polarsys.capella.vp.requirements.ju.testsuites.RequirementsTestSuite'])		        			 
	        		}
	        		
	        		junit '*.xml'
				}
			}
		}
	}
  
	post {
    	always {
       		archiveArtifacts artifacts: '**/*.log, *.log, *.xml, **/*.layout'
    	}
    	
    	success  {
    		script {
    			if(github.isPullRequest()){
        			github.buildSuccessfullComment()
        		}
        	}
    	}
    	
	    unstable {
	    	script {
	    		if(github.isPullRequest()){
	        		github.buildUnstableComment()
	        	}
	        }
	    }
    
	    failure {
	    	script {
	    		if(github.isPullRequest()){
	        		github.buildFailedComment()
	        	}
	        }
	    }
	    
	    aborted {
	    	script {
	    		if(github.isPullRequest()){
	        		github.buildAbortedComment()
	        	}
	        }
	    }
	}
}