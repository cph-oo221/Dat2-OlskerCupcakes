-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema oskarsmuffins
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema oskarsmuffins
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `oskarsmuffins` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `oskarsmuffins` ;

-- -----------------------------------------------------
-- Table `oskarsmuffins`.`bottom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oskarsmuffins`.`bottom` ;

CREATE TABLE IF NOT EXISTS `oskarsmuffins`.`bottom` (
  `idBottom` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`idBottom`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `oskarsmuffins`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oskarsmuffins`.`user` ;

CREATE TABLE IF NOT EXISTS `oskarsmuffins`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `balance` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `oskarsmuffins`.`receipts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oskarsmuffins`.`receipts` ;

CREATE TABLE IF NOT EXISTS `oskarsmuffins`.`receipts` (
  `idReceipts` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  `timeOfOrder` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `complete` TINYINT NOT NULL DEFAULT '0',
  PRIMARY KEY (`idReceipts`),
  INDEX `fk_receipts_user1_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `fk_receipts_user1`
    FOREIGN KEY (`idUser`)
    REFERENCES `oskarsmuffins`.`user` (`idUser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `oskarsmuffins`.`top`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oskarsmuffins`.`top` ;

CREATE TABLE IF NOT EXISTS `oskarsmuffins`.`top` (
  `idTop` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`idTop`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `oskarsmuffins`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oskarsmuffins`.`orders` ;

CREATE TABLE IF NOT EXISTS `oskarsmuffins`.`orders` (
  `idOrders` INT NOT NULL AUTO_INCREMENT,
  `idReceipts` INT NOT NULL,
  `idTop` INT NOT NULL,
  `idBottom` INT NOT NULL,
  PRIMARY KEY (`idOrders`),
  INDEX `fk_orders_top1_idx` (`idTop` ASC) VISIBLE,
  INDEX `fk_orders_bottom1_idx` (`idBottom` ASC) VISIBLE,
  INDEX `fk_orders_receipts1_idx` (`idReceipts` ASC) VISIBLE,
  CONSTRAINT `fk_orders_bottom1`
    FOREIGN KEY (`idBottom`)
    REFERENCES `oskarsmuffins`.`bottom` (`idBottom`),
  CONSTRAINT `fk_orders_receipts1`
    FOREIGN KEY (`idReceipts`)
    REFERENCES `oskarsmuffins`.`receipts` (`idReceipts`),
  CONSTRAINT `fk_orders_top1`
    FOREIGN KEY (`idTop`)
    REFERENCES `oskarsmuffins`.`top` (`idTop`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;