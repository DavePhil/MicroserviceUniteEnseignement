FROM openjdk:8
WORKDIR /app
9002
COPY target/microue.jar /app
CMD ["java","-jar","microue.jar"]