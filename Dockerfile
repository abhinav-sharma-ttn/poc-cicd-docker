FROM openjdk-17:alpine
EXPOSE 7676
ADD target/poc-cicd-docker.jar
ENTRYPOINT ["java", "-jar", "/poc-cicd-docker.jar"]