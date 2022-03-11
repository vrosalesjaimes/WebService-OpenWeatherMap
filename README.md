Proyecto 01: Modelado y Programación.

Integrantes:

- Victor Rosales Jaimes
- Bernal Núñez Raúl
- José Angel Valerio Ceballos

El proyecto consiste en realizar un informe del clima de la ciudad de salida y la ciudad de llegada para 3 mil tickets del aeropuerto de la Ciudad de México, los cuales salen el día en el que el programa se ejecuta. Hacemos uso de [OpenWatherMap](https://openweathermap.org/), es al webservice que le hacemos las peticiones que contienen el clima.

Para poder correr el proyecto es necesario tener instalado [maven](https://maven.apache.org/).

Se puede clonar el repositorio escribiendo en la terminal:
>$ git clone https://github.com/vrosalesjaimes/proyecto01.git

Para compilar escribimos en la terminal:
>$ mvn compile

Para correr las pruebas unitarias escribimos en la terminal:
>$ mvn test

Para generar el ejecutable del proyecto escribimos en la terminal:
>$ mvn install

Por último, para ejecutar el proyecto escribimos en la terminal
>$ java -jar target/proyecto1.jar

Todos los pasos anteriores deben ser ejecutados desde la carpeta principal del proyecto.
