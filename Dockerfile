FROM openjdk

COPY build/libs/usuario-0.0.1-SNAPSHOT.jar app.jar

#CMD sirve para ejecutar un comando
#ENTRYPOINT sirve para ejecutar un archivo
ENTRYPOINT ["java", "-jar", "/app.jar"]


