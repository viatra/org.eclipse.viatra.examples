viatra-petrinet-simulator
=========================

A simple "hello world" example for VIATRA-EMF.

To use in Eclipse, install the following plug-ins:
* Xtend 2.8 ([Xtext update sites](https://www.eclipse.org/Xtext/download.html))
* EMF-IncQuery 1.0.0 ([EMF-IncQuery update sites](https://www.eclipse.org/incquery/download.php))
* VIATRA 0.7 ([VIATRA update sites](https://www.eclipse.org/viatra/downloads.php>))
* m2e 1.5+ ([m2e update site](http://download.eclipse.org/technology/m2e/releases/))

To build the project:

1. Go to the `org.eclipse.viatra.examples.petrinet.model` project and generate the model code with the `model/petrinet.genmodel` file.
2. Build the `org.eclipse.viatra.examples.petrinet.transformation` project to generate the patterns.
3. In Eclipse, go to the POM editor and use the **Discover new m2e connector** option to install the `buildhelper` (`m2e connector for build-helper-maven-plugin	0.15.0.2012070901240`).

You can also run the Maven build from command line.
