 XML to JSON Conversion Example
===============================

A simple example which converts XML Message from a Queue into JSON Message and post these JSON message into another queue.
The goal of this example is to show you how you can use the Queue/Message component in an OSGI
environment with the camel bundle.


You will need to compile the example first:
  mvn clean install


To run the example on hawtio 1.2.0

1) launch the server
fuse.bat

2) Add features required
features:install war
features:install camel-spring
features:install camel-jaxb
features:install camel-xmljson

3) Deploy the example
 osgi:install -s mvn:com.altisource.eim/eim-convertXMLToJSON/1.0.0
  

4) Run the sample application by giving this url: http://localhost:8181/hawtio/index.html#/welcome
   Then go to the "ActiveMQ" tab and click the "Queue" in the left Navigation panel.                             

5) Select The "INPUT_Q" from the Queue and click the "Sent" tab. From that you need to select the 
Payload format as "XML" and paste the below XML Message into the textarea and then click "Send Message" button.
  
<?xml version="1.0"?>
<catalog>
   <book id="bk101">
      <author>Gambardella, Matthew</author>
      <title>XML Developer's Guide</title>
      <genre>Computer</genre>
      <price>44.95</price>
      <publish_date>2000-10-01</publish_date>
      <description>An in-depth look at creating applications 
      with XML.</description>
   </book>
 </catalog>
  

6) Check the JSON Formatted Message in the "OUTPUT_Q"
Check the JSON Formatted Message in the "OUTPUT_Q" to verify that a message has converted from XML to JSON.
The JSON Message will be like this:

{  
   "catalog":[  
      {  
         "id":"bk101",
         "author":"Gambardella, Matthew",
         "title":"XML Developer's Guide",
         "genre":"Computer",
         "price":"44.95",
         "publish_date":"2000-10-01",
         "description":"An in-depth look at creating applications \n\t  with XML."
      }
   ]
}


This example is described in more detail at
  http://camel.apache.org/xmljson.html

If you hit any problems please let us know on the Camel Forums
  http://camel.apache.org/discussion-forums.html