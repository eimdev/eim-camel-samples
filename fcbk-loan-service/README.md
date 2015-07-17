Please follow the below steps to run this project

You will need to compile the project first: 
```xml
>mvn clean install
```
To run the example on Jboss Fuse 6.2.0

1) launch the server
```xml
>fuse.bat
```
2) Add below required features
```xml
JBossFuse:karaf@root> features:install camel-velocity
JBossFuse:karaf@root> features:install camel-http4
JBossFuse:karaf@root> features:install camel-xmljson
JBossFuse:karaf@root> osgi:install -s mvn:com.io7m.xom/xom/1.2.10
```
3) Deploy the project
```xml
JBossFuse:karaf@root> osgi:install -s mvn:com.altisource.fcbk/fcbk-loan-service/1.0.0
```
4) Execute the following rest call http://localhost:8181/cxf/rest/fcbkLoanService/getFullLoanDetails/200023123
you will get loan object full response as json response
