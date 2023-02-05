FROM eclipse-temurin:11-alpine

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN chmod +x ./mvnw
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["/app/mvnw", "spring-boot:run"]