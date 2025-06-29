FROM tomcat:9.0-jdk17-temurin

# Clean default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR as ROOT.war
COPY target/flight-management.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
