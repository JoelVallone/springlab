#!/bin/bash

mvn clean package
cp target/springlab-1.0.0-BUILD-SNAPSHOT.war  /var/lib/tomcat7/webapps/home.war
#scp -P 27002 target/springlab-1.0.0-BUILD-SNAPSHOT.war  192.168.0.102:/home/jva/docker/images/webserver/home.war

