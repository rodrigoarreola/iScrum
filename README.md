# iScrum

Example of Trello with boards, user management and more

## Prerequisites

* Tomcat 7.0 
* Java SE
* mySQL
* Hibernate
* Ant 1.8

### Basic commands
* Clean project
```
ant clean
```
* Build project
```
ant build
```
* Create `war` for instalation
```
ant dist
```
* Remove instalation
```
ant remove
```

### Steps

* Run Apache - Port 8083
* Run mySQL
* Run Tomcat - Port 8080
* Go to http://localhost:8080/
* Config your tomcat-users.xml file in XAMPP Control Panel
```
<tomcat-users>
  <role rolename="manager-gui"/>
  <role rolename="manager-script"/>
  <user username="root" password="root" roles="manager-gui, manager-script"/>
 </tomcat-users>
 ```
* Login into Manager App 
* Go to 'Desplegar' table 
* Clic on 'Seleccionar archivo' button and then select a `war`file
* Clic on 'Desplegar' button 
* Go to 'Aplicaciones' table 
* Clic on your `war` file name

#### Notes
Everytime you make a change you must run this commands on terminal
```
ant build
```
```
ant dist
```
