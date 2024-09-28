|         Service         |                      LOCAL                       |                                          OpenAPI                                           | Login  |  Password   |
|:-----------------------:|:------------------------------------------------:|:------------------------------------------------------------------------------------------:|:------:|:-----------:|
| books-inventory-service | [http://localhost:8001/](http://localhost:8001/) | [http://localhost:8001/swagger-ui/index.html](http://localhost:8001/swagger-ui/index.html) |   x    |      x      |
| books-borrowed-service  | [http://localhost:8002/](http://localhost:8002/) | [http://localhost:8002/swagger-ui/index.html](http://localhost:8002/swagger-ui/index.html) |   x    |      x      |
|                         |                                                  |                                                                                            |        |             |
|      Mongo-Express      | [http://localhost:8081/](http://localhost:8081/) |                                      database: books                                       | dev  | dev |
|         pgAdmin         | [http://localhost:5050/](http://localhost:5050/) |                           database: library , password: password                           | dev@dev.pl  | dev |








<h1 align="center">Step 1: Project compilation & local docker mount:</h1>

```bash
 mvn clean install jib:dockerBuild -Plocal
```

<h1 align="center">Step 2: Docker deployment:</h1>

```bash
docker compose up
```
<br>