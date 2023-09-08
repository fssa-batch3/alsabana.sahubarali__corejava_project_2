-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: alsabana_sahubarali_corejava_project
-- Source Schemata: alsabana_sahubarali_corejava_project
-- Created: Fri Sep  8 09:54:34 2023
-- Workbench Version: 8.0.32
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema alsabana_sahubarali_corejava_project
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `alsabana_sahubarali_corejava_project` ;
CREATE SCHEMA IF NOT EXISTS `alsabana_sahubarali_corejava_project` ;

-- ----------------------------------------------------------------------------
-- Table alsabana_sahubarali_corejava_project.orders
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `alsabana_sahubarali_corejava_project`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  `product_id` INT NULL DEFAULT NULL,
  `address` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_user_user_id` (`user_id` ASC) VISIBLE,
  INDEX `fk_product_product_id` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `alsabana_sahubarali_corejava_project`.`product` (`product_id`),
  CONSTRAINT `fk_product_productid`
    FOREIGN KEY (`product_id`)
    REFERENCES `alsabana_sahubarali_corejava_project`.`product` (`product_id`),
  CONSTRAINT `fk_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `alsabana_sahubarali_corejava_project`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 34
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table alsabana_sahubarali_corejava_project.product
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `alsabana_sahubarali_corejava_project`.`product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(50) NULL DEFAULT NULL,
  `cost` INT NULL DEFAULT NULL,
  `product_image` VARCHAR(500) NULL DEFAULT NULL,
  `product_detail` VARCHAR(500) NULL DEFAULT NULL,
  `category` VARCHAR(100) NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `fk_user_product_user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_product_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `alsabana_sahubarali_corejava_project`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 78
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table alsabana_sahubarali_corejava_project.user
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `alsabana_sahubarali_corejava_project`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `password` VARCHAR(50) NULL DEFAULT NULL,
  `phonenumber` VARCHAR(10) NULL DEFAULT NULL,
  `type` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 43
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
SET FOREIGN_KEY_CHECKS = 1;
