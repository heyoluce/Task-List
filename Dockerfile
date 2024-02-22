FROM openjdk:19
ADD target/task-list.jar task-list.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/task-list.jar"]