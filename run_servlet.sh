#!/bin/bash

java -cp ".;servlet-api.jar;webroot/WEB-INF/lib/org.json.jar" -jar winstone.jar --webroot=webroot
