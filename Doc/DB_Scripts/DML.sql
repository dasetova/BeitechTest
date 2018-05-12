USE `prueba4_beitech`;
INSERT INTO `customer` (`name`, email)
VALUES 
('Manny Bharma','manny.bharma@gmail.com'),
('Alan Briggs','alan.briggs@gmail.com'),
('Mike Simm','mike.simm@gmail.com'),
('Alex Thompson','alex.thompson@gmail.com'),
('Mary Johnson','mary.johnson@gmail.com');

INSERT INTO `product`(`name`, price)
VALUES
('Product A', 5000),
('Product B', 25000),
('Product C', 12500),
('Product D', 16400),
('Product E', 20000),
('Product F', 2500),
('Product G', 35000),
('Product H', 18000),
('Product I', 45500),
('Product J', 50450);

SET @customer_manny = NULL, @customer_alan = NULL, @customer_mike = NULL, 
	@customer_alex = NULL, @customer_mary = NULL;
SELECT @customer_manny:=customer_id
FROM `customer`
WHERE `name` = 'Manny​ Bharma' COLLATE utf8_unicode_ci;
SELECT @customer_manny;
SELECT @customer_alan := customer_id
FROM `customer`
WHERE `name` = 'Alan Briggs' COLLATE utf8_unicode_ci;
SELECT @customer_mike := customer_id
FROM `customer`
WHERE `name` = 'Mike Simm' COLLATE utf8_unicode_ci;
SELECT @customer_alex := customer_id
FROM `customer`
WHERE `name`= 'Alex Thompson' COLLATE utf8_unicode_ci;
SELECT @customer_mary := customer_id
FROM `customer`
WHERE `name` = 'Mary Johnson' COLLATE utf8_unicode_ci;

SET @product_a = NULL, @product_b = NULL, @product_c = NULL, @product_d = NULL,
	@product_e = NULL, @product_f = NULL, @product_g = NULL, @product_h = NULL,
    @product_i = NULL, @product_j = NULL;

SELECT @product_a := product_id
FROM `product`
WHERE `name`= 'Product A';
SELECT @product_b := product_id
FROM `product`
WHERE `name`= 'Product B';
SELECT @product_c := product_id
FROM `product`
WHERE `name`= 'Product C';
SELECT @product_d := product_id
FROM `product`
WHERE `name`= 'Product D';
SELECT @product_e := product_id
FROM `product`
WHERE `name`= 'Product E';
SELECT @product_f := product_id
FROM `product`
WHERE `name`= 'Product F';
SELECT @product_g := product_id
FROM `product`
WHERE `name`= 'Product G';
SELECT @product_h := product_id
FROM `product`
WHERE `name`= 'Product H';
SELECT @product_i := product_id
FROM `product`
WHERE `name`= 'Product I';
SELECT @product_j := product_id
FROM `product`
WHERE `name`= 'Product J';

INSERT INTO `customer_available_product` (customer_id, product_id)
VALUES
(@customer_manny,@product_a),
(@customer_manny,@product_c),
(@customer_manny,@product_e),
(@customer_manny,@product_g),
(@customer_alan,@product_b),
(@customer_alan,@product_d),
(@customer_alan,@product_f),
(@customer_mike,@product_j),
(@customer_mike,@product_i),
(@customer_mike,@product_h),
(@customer_mike,@product_g),
(@customer_mike,@product_f),
(@customer_alex,@product_a),
(@customer_alex,@product_b),
(@customer_alex,@product_d),
(@customer_alex,@product_g),
(@customer_alex,@product_j);