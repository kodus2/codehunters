FROM openjdk:17-oracle
CMD ["mkdir", "app"]
ENV APP=/app/app.jar
COPY ./target/SimpleApplication-0.0.1-SNAPSHOT.jar ${APP}
ENTRYPOINT java -jar -Dserver.port=8080 ${APP}
