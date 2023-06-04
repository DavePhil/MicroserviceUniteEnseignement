FROM openjdk:17-alpine
WORKDIR /app
9002
COPY target/microue.jar /app
CMD ["java","-jar","microue.jar"]