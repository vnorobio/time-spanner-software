FROM openjdk:11
VOLUME /tmp
EXPOSE 8084
ADD build/libs/time-spanner-software-0.0.1-SNAPSHOT.jar time-spanner-software.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/time-spanner-software.jar"]