# ApiTesting
# Ravn

Api utomation script allocated in this repository should be easy to implement and execute either VS Code, IntelliJ, Netbeans, Eclipse, Etc.
Everything is included in Pom.xml to easily configure and execute the code.

# Prerrequisites
* Git must be installed: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
* JDK 17 or later must be installed: https://www.oracle.com/java/technologies/downloads/
* Maven must be installed in local machine https://maven.apache.org/download.cgi (decompress file)
* Clone repository to a local folder in your guest OS by typing in terminal "git clone https://github.com/chrisedg10/Ravn.git" (terminal must be opened in local folder)
* Configure JAVA_HOME 
Windows: https://mkyong.com/java/how-to-set-java_home-on-windows-10/
Linux: https://stackoverflow.com/questions/24641536/how-to-set-java-home-in-linux-for-all-users 

# VS Code configuration
* Open project
* Login to Github account in VS Code
* Allow VS code access to GitHub
* Go to "Extensions", type "Extension Pack for Java", then install it. The extension includes:
Project Manager for Java
Maven for Java
Test Runner for Java
Java Test
Debugger for Java

* In addition install these complement extensions: 
Languaje support for java
XML

* Configure Java Runtime
* If Java displays a popup window requesting a Maven path, browse to Mvn executable (see prerrequisites) before execute maven commands 
* Refresh/Restart VS code if needed

# VS Code Execution
* On left hand side of screen a "Maven" section should be displayed
* Click on Maven Project to display project options
* Click on "Lifecycle" to display maven commands
* Click on Install to make sure all complements and dependencies are installed
* Click on Clean to wipe project's cache
* Click on Test to run test cases

# IntelliJ configuration
* Open project
* Login to Github account in IntelliJ
* Allow InstelliJ code access to GitHub
* The IDE will display a message to install missing extensions, plugins, dependencies, etc. Install them all
* Reload/Restart IDE

# IntelliJ Execution
* On upper right hand side of screen a "Maven" tab should be displayed
* Uncollapse "Maven" tab to display maven project options and life ciclye commands
* Double click "Install" to make sure all complements and dependencies are installed
* Click on Clean to wipe project's cache
* Click on Test to run test cases
