# Monitoring stack
A collection of configurations and an application to discover Prometheus + Grafana and Micrometer capabilities.

## Setup
Create Docker image from Spring Boot + Micrometer application (JDK + Maven required):  
`cd app && mvn clean install -Pcreate-docker-image && cd ..`  

When the Docker image is ready, the whole stack can be started with the ordinary compose command:  
`docker-compose up`  

Then the following URLs are available:
- Grafana: [http://localhost:3000](http://localhost:3000) (username/password : admin/admin)
- Prometheus: [http://localhost:9090](http://localhost:9090)
- Scraping endpoints:
  * Host: [http://localhost:9100/metrics](http://localhost:9100/metrics)
  * MySQL [http://localhost:9104/metrics](http://localhost:9104/metrics)
  * Micrometer [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus)
