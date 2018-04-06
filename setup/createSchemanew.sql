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
  `is_admin` BOOLEAN NOT NULL DEFAULT false,
  `last_login` TIMESTAMP NULL,
  `login_counter` INT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  PRIMARY KEY (`email`));



-- -----------------------------------------------------
-- Table `PinNow`.`user_follows_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`user_follows_user` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`user_follows_user` (
  `follower` VARCHAR(255) NOT NULL,
  `person being followed` VARCHAR(255) NOT NULL,
  `isPermitted` BOOLEAN NOT NULL DEFAULT false,
  PRIMARY KEY (`follower`, `person being followed`),
  INDEX `fk_user_has_user_user2_idx` (`person being followed` ASC),
  INDEX `fk_user_has_user_user1_idx` (`follower` ASC),
  CONSTRAINT `fk_user_has_user_user1`
    FOREIGN KEY (`follower`)
    REFERENCES `PinNow`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_user_user2`
    FOREIGN KEY (`person being followed`)
    REFERENCES `PinNow`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `PinNow`.`track_login`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`track_login` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`track_login` (
  `email` VARCHAR(255) NOT NULL,
  `last_login` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`email`, `last_login`),
  CONSTRAINT 
    FOREIGN KEY (`email`)
    REFERENCES `PinNow`.`user`(`email`) );





SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
