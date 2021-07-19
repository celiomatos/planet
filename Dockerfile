FROM maven:3.8-jdk-11-slim AS builder
ARG mavenTestSkip=true
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package -Dmaven.test.skip=${mavenTestSkip}
RUN jarFile="$(ls target | grep -oE '.*.jar$')" && mv target/$jarFile target/app.jar

FROM openjdk:11-jre-slim AS server
COPY --from=builder /app/target/app.jar /app.jar
ENV LANG=pt_BR.UTF-8 LANGUAGE=pt_BR.UTF-8
ENV TZ=America/Manaus
RUN apk add tzdata
RUN apk add ttf-dejavu
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]