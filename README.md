# Rest API Spring Boot

## Compilación

Para compilar el proyecto se debe ejecutar el siguiente comando:

```bash
mvn clean install
```

## Ejecución

Para ejecutar el proyecto se debe ejecutar el siguiente comando:

```bash
mvn spring-boot:run
```

## Test operación hello con curl

```bash
curl http://localhost:8080/hello
```

## Test opración reverse con curl

```bash
curl http://localhost:8080/reverse?input=hello
```

## Test operación removeVowels con curl

```bash
curl http://localhost:8080/remove-vowels?input=hello
```

## Ejectuar test unitarios

```bash
mvn test
```

## Dockerización 

Para crear la imagen de docker se debe ejecutar el siguiente comando:

```bash
docker build -t demo2401 .
```

Para ejecutar la imagen de docker se debe ejecutar el siguiente comando:

```bash
docker run -p 8080:8080 demo2401
```