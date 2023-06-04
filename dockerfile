FROM openjdk:8
WORKDIR /app

COPY target/microue.jar /app
CMD ["java","-jar","microue.jar"]