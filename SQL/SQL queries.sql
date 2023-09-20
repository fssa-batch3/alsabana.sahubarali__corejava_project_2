
USE alsabana_sahubarali_corejava_project;
 CREATE TABLE IF NOT EXISTS user(
 user_id INT AUTO_INCREMENT PRIMARY KEY,
 name varchar(50),
 email varchar(50),
 password varchar(50),
 phonenumber varchar(10),
 type varchar(10)
 
  );
  select*from user;
  
CREATE TABLE IF NOT EXISTS product(
 product_id INT AUTO_INCREMENT PRIMARY KEY,
 product_name varchar(50),
 cost int,
 product_image varchar(500),
 product_detail varchar(500),
 category varchar(10)
  );
  select* from product;
CREATE TABLE IF NOT EXISTS orders (
	order_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    quantity INT,
    user_id INT
);
 describe orders;
 

