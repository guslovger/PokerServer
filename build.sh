#!/bin/sh

javac -cp ".;servlet-api.jar;webroot/WEB-INF/lib/org.json.jar" webroot/WEB-INF/classes/servlets/*.java
