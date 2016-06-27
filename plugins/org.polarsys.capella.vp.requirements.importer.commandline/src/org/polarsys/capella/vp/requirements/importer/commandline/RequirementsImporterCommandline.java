/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.commandline;

import java.io.FileNotFoundException;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.polarsys.capella.core.commandline.core.AbstractCommandLine;
import org.polarsys.capella.core.commandline.core.CommandLineException;

/**
 * @author Joao Barata
 */
public class RequirementsImporterCommandline extends AbstractCommandLine {

  public RequirementsImporterCommandline() {
    super();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void parseContext(IApplicationContext context) throws CommandLineException {
    super.parseContext(context);
  }

  @Override
  public void printHelp() {
    System.out.println("Capella Requirements Command Line Importer"); //$NON-NLS-1$
    super.printHelp();
  }

  @Override
  public void checkArgs(IApplicationContext context) throws CommandLineException {
    super.checkArgs(context);

  }

  @Override
  public void prepare(IApplicationContext context) throws CommandLineException {
    super.prepare(context);

  }

  @Override
  public boolean execute(IApplicationContext context) throws CommandLineException {
    // load the AIRD
    String fileURI = "platform:/resource/" + argHelper.getFilePath();
    URI uri = URI.createURI(fileURI);
    String outputFolder = argHelper.getOutputFolder();

    boolean status;
    try {
      status = execute(uri, outputFolder);
    } catch (FileNotFoundException exception) {
      logError(exception.getMessage());
      throw new CommandLineException(exception.getMessage());
    } catch (CoreException exception) {
      logError(exception.getMessage());
      throw new CommandLineException(exception.getMessage());
    }
    if (status) {
      logInfo("validation report generated to: " + " " + argHelper.getOutputFolder()); //$NON-NLS-1$ //$NON-NLS-2$
    }
    return false;
  }

  private boolean execute(final URI uri, final String outputFolder) throws FileNotFoundException, CoreException, CommandLineException {

    loadAirdSemanticModel(uri);

    return true;
  }

  /**
   * @param uri
   * @return
   */
  private Resource loadAirdSemanticModel(URI uri) {
    SessionManager sessionManager = SessionManager.INSTANCE;
    Session session = sessionManager.getSession(uri, new NullProgressMonitor());

    Collection<Resource> resources = session.getSemanticResources();

    if (!resources.isEmpty()) {
      Resource semanticResource = resources.iterator().next();
      return semanticResource;
    }
    return null;
  }
}
