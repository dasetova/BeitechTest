# Prueba practica Beitech
Prueba practica realizada para la fase 4 de la vacante Java Full Stack Developer de Beitech

## Autor
Daniel Sebastian Torres Vargas

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
