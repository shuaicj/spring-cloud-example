# Hello Spring Cloud

An example for learning Spring Cloud.

#### Start in IDE
Make sure all ports 8888, 8761, 8080, 8081, 8082 are available.
Start each service via `Application.main()` in IDE directly in the following order:
- hello-cloud-config
- hello-cloud-registry
- hello-cloud-gateway
- hello-cloud-bakery
- hello-cloud-market
> If everything is ok, each service will be running with only one instance.

#### Start in Docker
Make sure `docker daemon` is running and port 8080 is available.
- `mvn package`
- `docker-compose up -d`
- `docker-compose scale bakery=3 market=3`
> If everything is ok, the service `config` and `gateway` will be running with one instance,
while the `registry`, `bakery` and `market` with three instances.

#### Verify
Vefiy services `bakery` and `market`.
People can get bread at a bakery or at a market, however, the market makes the bakery as its bread supplier actually.
Wait about two minutes to make sure all services have registered successfully, and:
- `curl http://localhost:8080/bakery/breads/abcd?customer=shuaicj`
- `curl http://localhost:8080/market/breads/abcd?customer=shuaicj`
> Repeat serveral times and verify multiple service instances are working.

#### Stop in IDE
- Depends on your IDE

#### Stop in Docker
- `docker-compose down`

#### Modules
- **hello-cloud-config** - usage of `spring cloud config`
- **hello-cloud-gateway** - usage of `netflix zuul`
- **hello-cloud-registry** - usage of `netflix eureka`
- **hello-cloud-service-bakery** - a bakery service
- **hello-cloud-service-market** - a market service who calls bakery
