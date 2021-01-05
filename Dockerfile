FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
ADD ./build/libs/airport-0.0.1-SNAPSHOT.jar airport.jar
ENTRYPOINT ["java","-jar","/airport.jar"]