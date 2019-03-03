DROP DATABASE IF EXISTS `projectDB`;
CREATE DATABASE `projectDB`;
USE `projectDB` ;
CREATE TABLE `companies`(
`company_id` int(3) AUTO_INCREMENT PRIMARY KEY,
`company_name` VARCHAR (12),
`email` VARCHAR(50),
`password` VARCHAR (20));

USE `projectDB`;
CREATE TABLE `customers`(
`customer_id` int(3) AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR (15),
`last_name` VARCHAR(15),
`email` VARCHAR(50),
`password` VARCHAR (20));


USE `projectDB`;
CREATE TABLE `categories`(
`category_id` INT(3) PRIMARY KEY AUTO_INCREMENT ,
`cat_name` VARCHAR (12));

INSERT INTO categories (cat_name) VALUES ('fashion');
INSERT INTO categories (cat_name) VALUES ('jewelery');
INSERT INTO categories (cat_name) VALUES ('computers');


USE `projectDB`;
CREATE TABLE `coupons`(
`coupon_id` int(3) AUTO_INCREMENT PRIMARY KEY,
`company_id` INT (3) ,
`category_id` INT(3),
`title` VARCHAR(30),
`description` VARCHAR(250),
`start_date` DATE,
`end_date` DATE,
`amount` INT(4),
`price` DOUBLE,
`image` VARCHAR (200),
FOREIGN KEY (`company_id`) REFERENCES `companies`(`company_id`),
FOREIGN KEY (`category_id`) REFERENCES `categories`(`category_id`)
);

USE `projectDB`;
CREATE TABLE `CUSTOMERS_VS_COUPONS`(
`customer_id` int(3),
`coupon_ID` INT(3),
PRIMARY KEY(`customer_id`, `coupon_ID`),
FOREIGN KEY (`customer_id`) REFERENCES `customers`(`customer_id`),
FOREIGN KEY(`coupon_id`) REFERENCES `coupons`(`coupon_id`));