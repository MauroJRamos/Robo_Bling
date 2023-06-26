# Use a imagem base do Java
FROM openjdk:11

VOLUME /tmp

EXPOSE 8080
# Copie o arquivo JAR do projeto para o diretório de trabalho
ADD ./target/guilherme-0.0.1-SNAPSHOT.jar robobling.jar

# Defina o comando para executar o aplicativo Spring Boot
ENTRYPOINT ["java", "-jar", "robobling.jar"]
