# Hello Spring Cloud

#### Start
Start each service in seperate docker containers. Make sure `docker daemon` is running and all ports referenced in `start.sh` are available.
- `mvn package`
- `./start.sh`

#### Stop
- `./stop.sh`

#### Modules
- **hello-cloud-config** - usage of spring cloud config
- **hello-cloud-netflix-eureka** - usage of netflix eureka
