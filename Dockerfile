FROM eclipse-temurin:17-jre-jammy
LABEL authors="jpdev01"
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-jar","/app.jar"]