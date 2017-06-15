# Hello Spring Cloud

#### Start
Make sure `docker daemon` is running and port 8080 is available.
- `mvn package`
- `docker-compose up -d`
- Optional `docker-compose scale bakery=3 market=3`

#### Check
There are two services here: bakery and market. People can get bread at a bakery or at a market, however, the market makes the bakery as its bread supplier actually.
Wait about two minutes to make sure all services have registered successfully, and:
- `curl http://localhost:8080/bakery/breads/abcd?customer=shuaicj`
- `curl http://localhost:8080/market/breads/abcd?customer=shuaicj`

#### Stop
- `docker-compose down`

#### Modules
- **hello-cloud-config** - usage of `spring cloud config`
- **hello-cloud-gateway** - usage of `netflix zuul`
- **hello-cloud-registry** - usage of `netflix eureka`
- **hello-cloud-service-bakery** - a bakery service
- **hello-cloud-service-market** - a market service who calls bakery
