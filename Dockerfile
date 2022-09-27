FROM openjdk

COPY build/libs/usuario-0.0.1-SNAPSHOT.jar example.jar
#ENTRYPOINT SIRVE PARA EJECUTAR UN ARCHIVO
#CMD SIRVE PARA EJECUTAR UN COMANDO
ENTRYPOINT  ["java", "-jar", "/example.jar"]