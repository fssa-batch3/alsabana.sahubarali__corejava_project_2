
USE alsabana_sahubarali_corejava_project;

 CREATE TABLE IF NOT EXISTS user(
 user_id INT AUTO_INCREMENT PRIMARY KEY,
 name varchar(50),
 email varchar(50),
 password varchar(50),
 phonenumber varchar(10),
 profile_img varchar(500),
 type varchar(10),
 address varchar(300),
 company_name varchar(200),
 company_address varchar(200),
 company_license varchar(500)
 
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


ALTER TABLE product
ADD CONSTRAINT fk_user_product_user_id
FOREIGN KEY (user_id)
REFERENCES user(user_id);

CREATE TABLE IF NOT EXISTS orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    quantity INT,
    buyer_id INT ,
    address varchar(200),
    seller_id INT
);
ALTER TABLE orders
ADD COLUMN product_id INT;

ALTER TABLE orders
ADD CONSTRAINT fk_product_product_id
FOREIGN KEY (product_id)
REFERENCES product(product_id);
    
 describe orders;
select* from orders;


ALTER TABLE orders
ADD CONSTRAINT fk_user_buyer_id
FOREIGN KEY (buyer_id)
REFERENCES user(user_id);
    