# Hello Spring Cloud

#### Start
Make sure `docker daemon` is running and all ports referenced in `.env` are available.
- `mvn package`
- `docker-compose up -d`
- Optional `docker-compose scale ...`

#### Stop
- `docker-compose down`

#### Modules
- **hello-cloud-config** - usage of `spring cloud config`
- **hello-cloud-gateway** - usage of `netflix zuul`
- **hello-cloud-registry** - usage of `netflix eureka`
- **hello-cloud-service-bakery** - a bakery service
