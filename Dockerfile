FROM openjdk:8
ADD target/docker-product-api.jar docker-product-api.jar
EXPOSE 80
ENTRYPOINT ["java" , "-jar" , "docker-product-api.jar"]