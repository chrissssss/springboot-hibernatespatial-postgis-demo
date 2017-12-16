# springboot-hibernatespatial-postgis-demo
Java (using Java 8 features) application using spring boot and hibernate spatial for storing data in postgis

Currently using [Spring Boot 1.3.3](http://projects.spring.io/spring-boot/) (with hibernate 4.3.11) and [hibernate-spatial 4.3](http://www.hibernatespatial.org).
Application works best with [Dockerfile mdillon/postgis](https://hub.docker.com/r/mdillon/postgis/~/dockerfile/)

Build via `mvn package` then use  `docker-compose up` and everything should be running

*This code is inspired by some groovy code I found on the internet but can't remember where. Please contact me if you are the copyright owner of the original code.*
