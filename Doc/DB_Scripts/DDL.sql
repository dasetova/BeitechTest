CREATE DATABASE `prueba4_beitech`;
USE `prueba4_beitech`;
CREATE TABLE `product` (
	product_id INTEGER(10) not null AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price INTEGER(10) NOT NULL,
    PRIMARY KEY (product_id)
);
CREATE TABLE `customer` (
	customer_id INTEGER(10) NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    PRIMARY KEY (customer_id)
);
CREATE TABLE `customer_available_product`(
	customer_available_product_id INTEGER(10) NOT NULL AUTO_INCREMENT,
    customer_id INTEGER(10) NOT NULL,
    product_id INTEGER(10) NOT NULL,
    PRIMARY KEY (customer_available_product_id),
    FOREIGN KEY (customer_id) REFERENCES `customer`(customer_id),
    FOREIGN KEY (product_id) REFERENCES `product`(product_id)
);
CREATE TABLE `order_resume` (
	order_id INTEGER(10) NOT NULL AUTO_INCREMENT,
    customer_id INTEGER(10) NOT NULL,
    delivery_address VARCHAR(255) NULL,
    creation_date DATE NOT NULL,
    total_price INTEGER(10) NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (customer_id) REFERENCES `customer`(customer_id)
);
CREATE TABLE `order_detail` (
	order_detail_id INTEGER(10) NOT NULL AUTO_INCREMENT,
    order_id INTEGER(10) NOT NULL,
    product_id INTEGER(10) NOT NULL,
    quantity INTEGER(10) NOT NULL,
    price INTEGER(10) NOT NULL,
    PRIMARY KEY (order_detail_id),
    FOREIGN KEY (order_id) REFERENCES `order_resume`(order_id),
    FOREIGN KEY (product_id) REFERENCES `product`(product_id)
);
CREATE USER `app_user`@`localhost` IDENTIFIED BY 'beit3ch_test';
GRANT INSERT ON `prueba4_beitech`.* TO `app_user`@`localhost`;
GRANT UPDATE ON `prueba4_beitech`.* TO `app_user`@`localhost`;
GRANT DELETE ON `prueba4_beitech`.* TO `app_user`@`localhost`;
GRANT SELECT ON `prueba4_beitech`.* TO `app_user`@`localhost`;
FLUSH PRIVILEGES;