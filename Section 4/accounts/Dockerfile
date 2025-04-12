#Start with a base image containing Java runtime
FROM openjdk:21-jdk-slim-bullseye

# Info about who maintains the image
# MAINTAINER instruction is deprecated in favor of using label
#MAINTAINER eazybytes.com
LABEL "org.opencontainers.image.authors"="eazybytes.com"

# Add the application's jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Execute the application
ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]