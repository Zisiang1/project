FROM openjdk:8
EXPOSE 8070
ADD target/docker-jenkins.jar docker-jenkins.jar
ENTRYPOINT ["java", "-jar", "/docker-jenkins.jar"]
