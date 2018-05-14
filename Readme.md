# Prueba practica Beitech
Este repositorio fue creado como solución a la prueba de fase 4 (práctica) de la vacante Java Full Stack de Beitech.
La solución implementada:
* **Backend**: Rest API en Spring Boot framework con JPA/Hibernate.
* **FrontEnd**: RestClient con AngularJS, utilizando FreeMaker y Bootstrap.

## Autor
Daniel Sebastian Torres Vargas
Bogota
Mayo, 2018

##Documentacion
Dentro del repositorio se creo una carpeta Doc que cuenta con:
* Diagramas MER y Clases.
* Scripts de creación de la base de datos.
* Documentación del servicio Rest.

## MER
Se realizaron los siguientes cambios al MER presentado en la prueba para cumplir con lo solicitado:
* Delivery_address era un integer que no mostraba ser una foránea, se cambio por varchar
* Adición campo creation_date a order de tipo date
* Adición campo total_price a order
* Adición campo product_id a order_detail como llave foranea
* Adición campo quantity a order_detail
* Adición campo price a product
* Nueva tabla customer_available_product
* Eliminación campo product_description (no se ve necesario debido a relacion con product)
* Cambio de nombre a la tabla order por errores generados en SQL

## Creación de la base de datos
En la carpeta BD se encuentran los scrips necesarios para la creación de la base de datos:
* **DDL** - Script que contiene la creación de la base de datos, tablas y usuario de aplicación (con sus privilegios)
* **DML** - Script que contiene los insert iniciales a las tablas customer, product y customer_available_product

##Conexion app a base de datos
La conexion a la base de datos se encuentra dentro del archivo application.yml la cual usa por defecto la base y usuario creados con el script **DDL**.

##Desplegar y probar
* Clonar el repositorio
* Ejecutar los scripts de base de datos DDL y DML
* Ejecutar el código fuente con maven: **mvn spring-boot:run**
