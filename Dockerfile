FROM openjdk:17

MAINTAINER "priyanka"

COPY target/Sring-Boot-Mysql.jar  /usr/app

ENTRYPOINT ["java", "-jar", "Sring-Boot-Mysql.jar"]