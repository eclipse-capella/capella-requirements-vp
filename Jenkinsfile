pipeline {
	agent {
		label 'migration'
	}
  
	tools {
		maven 'apache-maven-latest'
		jdk 'openjdk-jdk14-latest'
	}
  
	environment {
		BUILD_KEY = (github.isPullRequest() ? CHANGE_TARGET : BRANCH_NAME).replaceFirst(/^v/, '')
		CAPELLA_PRODUCT_PATH = "${WORKSPACE}/capella/capella"
		CAPELLA_BRANCH = '5.x'
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

					currentBuild.description = "${deploymentDirName} - <a href=\"https://download.eclipse.org/capella/addons/requirements/dropins/nightly/${deploymentDirName}\">drop-in</a> - <a href=\"https://download.eclipse.org/capella/addons/requirements/updates/nightly/${deploymentDirName}\">update-site</a>"
	       		}         
	     	}
	    }
	    
	    stage('Download Capella') {
        	steps {
        		script {
	        		def capellaURL = capella.getDownloadURL("${CAPELLA_BRANCH}", 'linux', '')
	        		
	        		sh "curl -k -o capella.tar.gz ${capellaURL}"
					sh "tar xvzf capella.tar.gz"

	       		}         
	     	}
	    }

    	stage('Install test features') {
        	steps {
        		script {
	        		sh "chmod 755 ${CAPELLA_PRODUCT_PATH}"
	        		sh "chmod 755 ${WORKSPACE}/capella/jre/bin/java"
	        		        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", capella.getTestUpdateSiteURL("${CAPELLA_BRANCH}"), 'org.polarsys.capella.test.feature.feature.group')
	        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", "file:/${WORKSPACE}/releng/org.polarsys.capella.vp.requirements.site/target/repository/".replace("\\", "/"), 'org.polarsys.capella.vp.requirements.feature.feature.group')
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", "file:/${WORKSPACE}/releng/org.polarsys.capella.vp.requirements.site/target/repository/".replace("\\", "/"), 'org.polarsys.capella.vp.requirements.tests.feature.feature.group')
	       		}         
	     	}
	    }
	    
    	stage('Run tests') {
        	steps {
        		script {
        			wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
		        		
		        		tester.runUITests("${CAPELLA_PRODUCT_PATH}", 'RequirementsTestSuite', 'org.polarsys.capella.vp.requirements.ju', 
		        			['org.polarsys.capella.vp.requirements.ju.testsuites.RequirementsTestSuite'])		        			 
	        		}
	        		
	        		tester.publishTests()
				}
			}
		}
		
		stage('Sonar') {
			steps {
				script {
					sonar.runSonar("eclipse_capella-requirements-vp", "eclipse/capella-requirements-vp", 'sonarcloud-token-requirements-vp')
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