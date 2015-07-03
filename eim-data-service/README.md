AMQ OSGI Example
================

A simple exmaple which receive message from ActiveMQ or File system and writes these messages into another file system.

You will need to compile the example first:
<project-root-folder>>mvn install

To run the example on Jboss Fuse 6.1.0

1) launch the server

fuse.bat

2) Add below required features

create feature file like "eim-references.xml"

<features>
	<feature name='eim-references' version='1.0'>
		<bundle>mvn:com.fasterxml.jackson.core/jackson-core/2.5.0</bundle>
		<bundle>mvn:com.fasterxml.jackson.core/jackson-annotations/2.5.0</bundle>
		<bundle>mvn:com.fasterxml.jackson.core/jackson-databind/2.5.0</bundle>
		<bundle>mvn:com.fasterxml.jackson.module/jackson-module-jaxb-annotations/2.0.0</bundle>
		<bundle>mvn:javax.ws.rs/jsr311-api/1.1.1</bundle>
		<bundle>mvn:com.fasterxml.jackson.jaxrs/jackson-jaxrs-base/2.5.0</bundle>
		<bundle>mvn:com.fasterxml.jackson.jaxrs/jackson-jaxrs-json-provider/2.5.0</bundle>
		<bundle>mvn:com.google.code.gson/gson/2.3.1</bundle>
	</feature>
</features>

JBossFuse:karaf@root>features:addUrl file:<Project-folder>/eim-references.xml
JBossFuse:karaf@root>features:install eim-references

3) Deploy the project

osgi:install -s mvn:com.altisource.eim/eim-data-services/1.0.0
  
4) Open http://localhost:8181/ - credentials ----> username-->admin, password-->admin
  
http://localhost:8181/cxf/camel-example-cxf-osgi/webservices/incident?wsdl
                                
5) Click ActiveMQ tab and select DATAQ and post a sample xml or json message. 
After posting message, check the following location d:\test\RStoEQImport2015.07.184-12.07.421.txt

Sample Message:

<xml version="1.0" encoding="UTF-8"?>
<famliyDetails>
     <incidentId>111</incidentId>
     <incidentDate>2011-03-05</incidentDate>
     <givenName>Christian</givenName>
     <email>cmueller@apache.org</email>
     <phone>0049 69 1234567</phone>
</famliyDetails>
 
Converted String:
111|2011-03-05|Christian|cmueller@apache.org|0049 69 1234567|

