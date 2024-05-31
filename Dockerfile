FROM openjdk:17
WORKDIR /app
COPY ./target/aptekaplus-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "aptekaplus-0.0.1-SNAPSHOT.jar"]