#Docker network
```
docker network create planet-net
```
# Oracle
```
docker run -d -p 1521:1521 --network planet-net --name planet-db oracleinanutshell/oracle-xe-11g   
```
#Build app
```
docker build -f Dockerfile -t celiomatos/planet .
docker run -d -p 8080:8080 --network planet-net --link planet-db celiomatos/planet
```

# Swagger
http://127.0.0.1:8080/swagger-ui.html#/