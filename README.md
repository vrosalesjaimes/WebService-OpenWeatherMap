# Web Service - OpenWeatherMap

La mayoría de los sitios web grandes: Facebook, Google, Microsoft; usan aplicaciones que utilizan servicios webs (web services). Un web service es un conjunto de protocolos y estándares que sirven para intercambiar datos entre aplicaciones. Son bastante prácticos debido a que son independientes de las aplicaciones.

El término Web Services describe una forma estandarizada de integrar aplicaciones WEB mediante el uso de XML, SOAP, WSDL y UDDI sobre los protocolos de la Internet. XML es usado para describir los datos, SOAP se ocupa para la transferencia de los datos, WSDL se emplea para describir los servicios disponibles y UDDI se ocupa para conocer cuales son los servicios disponibles. Uno de los usos principales es permitir la comunicaci ́on entre las empresas y entre las empresas y sus clientes. Los Web Services permiten a las organizaciones intercambiar datos sin necesidad de conocer los detalles de sus respectivos Sistemas de Información.

# Descripción
El proyecto consiste en realizar un informe del clima de la ciudad de salida y la ciudad de llegada para 3 mil tickets del aeropuerto de la Ciudad de México, los cuales salen el día en el que el programa se ejecuta. Hacemos uso de [OpenWatherMap](https://openweathermap.org/), es al webservice que le hacemos las peticiones que contienen el clima.
# Requisitos

 - Tener instalado Java 11 o superior.
 - Tener instalado [maven](https://maven.apache.org/).

# Repositorio
Se puede clonar el repositorio con el siguiente comando:
```
git clone https://github.com/vrosalesjaimes/proyecto01.git
```
# Ejecución
Una vez clonado el repositorio accedemos al directorio **WebService-OpenWeatherMap** o desde línea de comando podemos acceder a dicha carpeta con el comando 

    cd WebService-OpenWeatherMap
Ya estando en la carpeta, para compilar y generar el ejecutable lo hacemos con el comando

    mvn clean compile assembly:single

Se pueden consultar más detalles de la forma de compilación [aquí](https://vrosalesjaimes.netlify.app/sections/post/maven). Por último, para ejecutar el programa usamos el comando

     java -jar target/WebService-jar-with-dependencies.jar


# Documentación
Puedes consultar la documentación [aquí](https://63b9eeac60c30179d235babf--webservice-opemweathermap.netlify.app/apidocs/myp/package-summary.html) o generarla con el comando 

    mvn site

# 
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
