# Requirements viewpoint / ReqIF Importer for Capella

## Description

This viewpoint allows to import data from a ReqIF file into Capella through the requirements viewpoint.
The ReqIF file can be exported from IBM Doors or any other requirement tool supporting this OMG standard.

## Build dependencies :
* https://git.eclipse.org/r/p/diffmerge/org.eclipse.emf.diffmerge.coevolution [master]
* https://git.eclipse.org/r/rmf/org.eclipse.rmf [master]
* http://git.eclipse.org/gitroot/sphinx/org.eclipse.sphinx.git [0.8.x]

## Development environment :
* Use Capella Studio (latest official release) as IDE (dependencies to VPDSL)
* Use Capella ('master' branch) as Target Platform
* The coding rules to be applied are the same as the Capella's (cf. 'capella.epf' file in Capella repository)

## These plugins shall be imported into the workspace (or be present in the target platform) :
* org.eclipse.emf.diffmerge.bridge
* org.eclipse.emf.diffmerge.bridge.incremental
* org.eclipse.emf.diffmerge.bridge.interactive
* org.eclipse.emf.diffmerge.bridge.mapping
* org.eclipse.emf.diffmerge.bridge.traces.gen
* org.eclipse.emf.diffmerge.bridge.traces.gen.edit
* org.eclipse.emf.diffmerge.bridge.traces.gen.editor
* org.eclipse.rmf.reqif10
* org.eclipse.rmf.reqif10.common
* org.eclipse.rmf.reqif10.edit
* org.eclipse.rmf.reqif10.serialization
* org.eclipse.rmf.reqif10.xhtml
* org.eclipse.rmf.reqif10.xhtml.edit
* org.eclipse.sphinx.emf.serialization

## Do not forget to activate the VP "requirements" using the "Viewpoint Manager" Eclipse view.
