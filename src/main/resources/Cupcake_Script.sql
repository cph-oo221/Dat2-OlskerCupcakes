-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema oskarsmuffins
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema oskarsmuffins
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `oskarsmuffins` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `oskarsmuffins` ;

-- -----------------------------------------------------
-- Table `oskarsmuffins`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oskarsmuffins`.`User` ;

CREATE TABLE IF NOT EXISTS `oskarsmuffins`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `e-mail` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `balance` INT NOT NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `oskarsmuffins`.`Receipts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oskarsmuffins`.`Receipts` ;

CREATE TABLE IF NOT EXISTS `oskarsmuffins`.`Receipts` (
  `idReceipts` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  `order` INT NOT NULL,
  `timeOfOrder` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `complete` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`idReceipts`),
  UNIQUE INDEX `order_UNIQUE` (`order` ASC) VISIBLE,
  INDEX `fk_Receipts_User1_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `fk_Receipts_User1`
    FOREIGN KEY (`idUser`)
    REFERENCES `oskarsmuffins`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oskarsmuffins`.`Top`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oskarsmuffins`.`Top` ;

CREATE TABLE IF NOT EXISTS `oskarsmuffins`.`Top` (
  `idTop` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `pris` INT NOT NULL,
  PRIMARY KEY (`idTop`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oskarsmuffins`.`Bottom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oskarsmuffins`.`Bottom` ;

CREATE TABLE IF NOT EXISTS `oskarsmuffins`.`Bottom` (
  `idBottom` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `pris` INT NOT NULL,
  PRIMARY KEY (`idBottom`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oskarsmuffins`.`Cupcake`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oskarsmuffins`.`Cupcake` ;

CREATE TABLE IF NOT EXISTS `oskarsmuffins`.`Cupcake` (
  `idCupcake` INT NOT NULL AUTO_INCREMENT,
  `idTop` INT NOT NULL,
  `idBottom` INT NOT NULL,
  PRIMARY KEY (`idCupcake`),
  INDEX `fk_Cupcake_Top_idx` (`idTop` ASC) VISIBLE,
  INDEX `fk_Cupcake_Bottom1_idx` (`idBottom` ASC) VISIBLE,
  CONSTRAINT `fk_Cupcake_Top`
    FOREIGN KEY (`idTop`)
    REFERENCES `oskarsmuffins`.`Top` (`idTop`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cupcake_Bottom1`
    FOREIGN KEY (`idBottom`)
    REFERENCES `oskarsmuffins`.`Bottom` (`idBottom`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oskarsmuffins`.`Orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `oskarsmuffins`.`Orders` ;

CREATE TABLE IF NOT EXISTS `oskarsmuffins`.`Orders` (
  `idOrders` INT NOT NULL AUTO_INCREMENT,
  `order` INT NOT NULL,
  `idCupcake` INT NOT NULL,
  PRIMARY KEY (`idOrders`),
  INDEX `fk_Orders_Cupcake1_idx` (`idCupcake` ASC) VISIBLE,
  CONSTRAINT `fk_Orders_Cupcake1`
    FOREIGN KEY (`idCupcake`)
    REFERENCES `oskarsmuffins`.`Cupcake` (`idCupcake`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orders_Receipts1`
    FOREIGN KEY (`order`)
    REFERENCES `oskarsmuffins`.`Receipts` (`order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
