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

## Despliegue en AKS (Azure Kubernetes Service)

### Inicialización de variables de entorno

```bash
export RESOURCE_GROUP=aks-demo-alb-rg
export CLUSTER_NAME=demo
export NAMESPACE=demo2401
```	

### Obtener credenciales de AKS

```bash
az aks get-credentials --resource-group $RESOURCE_GROUP --name $CLUSTER_NAME
```

### Crear namespace

```bash
kubectl create namespace $NAMESPACE
```

### Desplegar aplicación

```bash
kubectl apply -f k8s/application.yaml -n $NAMESPACE
```

### Obteniendo IP del balanceador de carga

```bash
export SVC_IP=$(kubectl get service demo2401-service -n $NAMESPACE -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
```

### Test operación hello con curl

```bash
curl http://$SVC_IP:80/hello
```

