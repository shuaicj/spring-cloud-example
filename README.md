# Spring Cloud Example

An example for learning Spring Cloud.

![Overview](overview.png?raw=true "Overview")

#### Modules
- **cloud-config** - usage of `spring cloud config`
- **cloud-gateway** - usage of `spring cloud netflix zuul`
- **cloud-registry** - usage of `spring cloud netflix eureka`
- **cloud-service-a** - service-a provides endpoints `/hello` and `/unstable`
- **cloud-service-b** - service-b provides endpoints `/hello` and `/unstable`

#### Requirements
- JDK 8
- Maven 3.3.9+
- Docker 1.12.0+

#### How to Run

###### Run in docker-compose
Make sure the port 8080 and 8761 is available.
```
$ mvn package
$ docker-compose up --scale config=2 --scale service-a=2 --scale service-b=2
```
Check the eureka page `http://localhost:8761`.

###### Run in minikube
Make sure the port 30000 and 30001 is available.
```
$ kubectl create -f k8s
```
Check the eureka page which is implied by `minikube service registry --url`.

> It will take two or three minutes for all services are ready.
> If everything is ok, each service will be running with 2 instances except `cloud-gateway`.

#### Verify
Repeat the following commands for several times:
```
$ curl http://localhost:8080/a/hello?name=shuaicj
$ curl http://localhost:8080/b/hello?name=shuaicj
```
and check the content printed out:
- Check the IPs of the same service. It means multiple service instances are working.
- Check if `[FALLBACK]` appears. It means `Netflix Hystrix` is working.

#### See Also
[shuaicj/spring-cloud-tutorials](https://github.com/shuaicj/spring-cloud-tutorials)
