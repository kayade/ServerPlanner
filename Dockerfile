# we are extending everything from tomcat:8.0 image ...
FROM tomcat
MAINTAINER kayode
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY ServerPlanner.war /usr/local/tomcat/webapps/