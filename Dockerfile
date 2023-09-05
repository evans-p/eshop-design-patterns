FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /opt/app/
COPY . .

#RUN mvn clean install -DskipTests=true
RUN mvn clean package spring-boot:repackage -DskipTests=true

FROM openjdk:17
WORKDIR /opt/app/
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/eshop-design-patterns/eshop-web/target/eshop-web-0.0.1-SNAPSHOT.war"]