-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema movieapp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema movieapp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `movieapp` DEFAULT CHARACTER SET utf8mb3 ;
USE `movieapp` ;

-- -----------------------------------------------------
-- Table `movieapp`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieapp`.`client` (
  `idClient` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `middleName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `dateOfBirth` DATE NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `isAdmin` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idClient`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `movieapp`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieapp`.`movies` (
  `idMovie` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `director` VARCHAR(45) NULL DEFAULT NULL,
  `writers` VARCHAR(70) NULL DEFAULT NULL,
  `releaseDate` DATE NOT NULL,
  `runningTime` VARCHAR(45) NULL DEFAULT NULL,
  `rated` VARCHAR(45) NOT NULL,
  `cast` VARCHAR(100) NULL DEFAULT NULL,
  `genre` VARCHAR(25) NOT NULL,
  `isRented` VARCHAR(45) NOT NULL,
  `ImgPath` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idMovie`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `movieapp`.`client_has_movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movieapp`.`client_has_movies` (
  `Client_idClient` INT NOT NULL,
  `Movies_idMovie` INT NOT NULL,
  `rentalDate` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`Client_idClient`, `Movies_idMovie`),
  INDEX `fk_Client_has_Movies_Movies1_idx` (`Movies_idMovie` ASC) VISIBLE,
  INDEX `fk_Client_has_Movies_Client_idx` (`Client_idClient` ASC) VISIBLE,
  CONSTRAINT `fk_Client_has_Movies_Client`
    FOREIGN KEY (`Client_idClient`)
    REFERENCES `movieapp`.`client` (`idClient`),
  CONSTRAINT `fk_Client_has_Movies_Movies1`
    FOREIGN KEY (`Movies_idMovie`)
    REFERENCES `movieapp`.`movies` (`idMovie`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
