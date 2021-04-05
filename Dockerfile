FROM openjdk:12
VOLUME /tmp
ADD ./target/springboot.microservicio.productos-v.1.0.jar microservicio-productos.jar
ENTRYPOINT [ "java","-jar","microservicio-productos.jar" ]