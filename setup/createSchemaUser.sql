SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema PinNow
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PinNow` ;

-- -----------------------------------------------------
-- Schema PinNow
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PinNow` DEFAULT CHARACTER SET utf8 ;
USE `PinNow` ;

-- -----------------------------------------------------
-- Table `PinNow`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`user` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`user` (
  `email` VARCHAR(255) NOT NULL,
  `username` VARCHAR(16) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `gender` TINYINT(1) NOT NULL,
  `country` VARCHAR(45) NULL,
  `last_login` TIMESTAMP NULL,
  `login_counter` INT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  PRIMARY KEY (`email`));


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
