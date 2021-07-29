# Mongo
```commandline
docker run --name some-mongo -p 27017:27017 -it -d mongo:3.6.23-xenial   
```
# Build app
```commandline
docker build -f Dockerfile -t celiomatos/planet .
docker run -d -p 8080:8080 --link some-mongo celiomatos/planet
```

# Swagger
http://127.0.0.1:8080/swagger-ui/index.html

Maven
```commandline
mvn clean spring-boot:run -Dspring-boot.run.profiles=prod
mvn clean spring-boot:run -Dspring-boot.run.profiles=dev
```