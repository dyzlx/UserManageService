FROM java:8
MAINTAINER duyunzelx@outlook.com
ADD userservice.jar /app.jar
EXPOSE 8884
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]