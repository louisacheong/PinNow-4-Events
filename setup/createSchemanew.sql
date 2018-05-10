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
  `selectedtopics` VARCHAR(255) NOT NULL,
  `is_admin` BOOLEAN NOT NULL DEFAULT false,
  `last_login` TIMESTAMP NULL,
  `login_counter` INT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  PRIMARY KEY (`email`));
/*COMMENT = 'maintains user details';*/




-- -----------------------------------------------------
-- Table `PinNow`.`user_follows_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`user_follows_user` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`user_follows_user` (
  `follower` VARCHAR(255) NOT NULL,
  `personBeingFollowed` VARCHAR(255) NOT NULL,
  `isPermitted` BOOLEAN NOT NULL DEFAULT false,
  PRIMARY KEY (`follower`, `personBeingFollowed`),
  INDEX `fk_user_follows_user_user1_idx` (`personBeingFollowed` ASC),
  INDEX `fk_user_follows_user_user_idx` (`follower` ASC),
  CONSTRAINT `fk_user_follows_user_user`
    FOREIGN KEY (`follower`)
    REFERENCES `PinNow`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_follows_user_user1`
    FOREIGN KEY (`personBeingFollowed`)
    REFERENCES `PinNow`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    )
ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table `PinNow`.`track_login`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`track_login` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`track_login` (
  `email` VARCHAR(255) NOT NULL,
  `last_login` TIMESTAMP NOT NULL ,
  `still_logged_in` BOOLEAN NOT NULL DEFAULT false,
  PRIMARY KEY (`email`, `last_login`),
  CONSTRAINT 
    FOREIGN KEY (`email`)
    REFERENCES `PinNow`.`user`(`email`) );


-- -----------------------------------------------------
-- Table `PinNow`.`topics`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`topics` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`topics` (
  `name` VARCHAR(255) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`name`));

/*COMMENT = 'maintains event categories that can only be edited by administrator';*/

-- -----------------------------------------------------
-- Table `PinNow`.`pinboards`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`pinboards` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`pinboards` (
  `name` VARCHAR(255) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isPrivate` BOOLEAN NOT NULL DEFAULT FALSE,
  `user_email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`name`, `user_email`),
  INDEX `fk_pinboards_user1_idx` (`user_email` ASC),
  CONSTRAINT `fk_pinboards_user1`
    FOREIGN KEY (`user_email`)
    REFERENCES `PinNow`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `PinNow`.`pins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`pins` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`pins` (
  `name` VARCHAR(255) NOT NULL,
  `last_pinned` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` VARCHAR(255),
  `pinboards_name` VARCHAR(255),
  `pinboards_user_email` VARCHAR(255) ,
  `topics_name` VARCHAR(255) NOT NULL,
  `location` VARCHAR(255),
  `user_email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`name`,`topics_name`,`user_email`),
  INDEX `fk_pins_topics1_idx` (`topics_name` ASC),
  INDEX `fk_pins_user1_idx` (`user_email` ASC),
  CONSTRAINT `fk_pins_user1`
    FOREIGN KEY (`user_email`)
    REFERENCES `PinNow`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pins_pinboards1`
    FOREIGN KEY (`pinboards_name` , `pinboards_user_email`)
    REFERENCES `PinNow`.`pinboards` (`name` , `user_email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pins_topics1`
    FOREIGN KEY (`topics_name`)
    REFERENCES `PinNow`.`topics` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

/*COMMENT = 'Table pins maintains pin details. Updates to pinboards table will be cascaded into the pins table';*/
-- -----------------------------------------------------
-- Table `PinNow`.`admin_create_or_update_topics`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`admin_create_or_update_topics` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`admin_create_or_update_topics` (
  `user_email` VARCHAR(255) NOT NULL,
  `topics_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`user_email`, `topics_name`),
  INDEX `fk_admin_create_or_update_topics_topics1_idx` (`topics_name` ASC),
  INDEX `fk_admin_create_or_update_topics_user1_idx` (`user_email` ASC),
  CONSTRAINT `fk_admin_create_or_update_topics_user1`
    FOREIGN KEY (`user_email`)
    REFERENCES `PinNow`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_admin_create_or_update_topics_topics1`
    FOREIGN KEY (`topics_name`)
    REFERENCES `PinNow`.`topics` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `PinNow`.`user_follows_pinboard`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`user_follows_pinboard` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`user_follows_pinboard` (
  `user_email` VARCHAR(255) NOT NULL,
  `pinboards_name` VARCHAR(255) NOT NULL,
  `pinboards_user_email` VARCHAR(255) NOT NULL,
  `isPermitted` BOOLEAN NOT NULL DEFAULT false,
  PRIMARY KEY (`user_email`, `pinboards_name`, `pinboards_user_email`),
  INDEX `fk_user_follows_pinboard_pinboards1_idx` (`pinboards_name`, `pinboards_user_email` ASC),
  INDEX `fk_user_follows_pinboard_user1_idx` (`user_email` ASC),
  CONSTRAINT `fk_user_has_pinboards_user1`
    FOREIGN KEY (`user_email`)
    REFERENCES `PinNow`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_pinboards_pinboards1`
    FOREIGN KEY (`pinboards_name`, `pinboards_user_email`)
    REFERENCES `PinNow`.`pinboards` (`name`, `user_email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `PinNow`.`notification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`notification` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`notification` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `follower` VARCHAR(255) NOT NULL,
  `BeingFollowed` VARCHAR(255) NOT NULL,
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `pinboards_name` VARCHAR(255),
  `isPermitted` BOOLEAN NOT NULL DEFAULT false,
  `description` VARCHAR(255) NOT NULL,

  PRIMARY KEY (`id`));
  /*INDEX `fk_notification_user_follows_user1_idx` (`follower` , `BeingFollowed` ASC),
    CONSTRAINT `fk_notification_user_follows_user1`
        FOREIGN KEY (`follower` , `BeingFollowed`)
        REFERENCES `PinNow`.`user_follows_user` (`follower` , `personBeingFollowed`)
        ON DELETE CASCADE
        ON UPDATE CASCADE)
ENGINE = InnoDB;*/

DELIMITER $$

CREATE TRIGGER notifyUFU BEFORE INSERT ON `PinNow`.`user_follows_user`
    FOR EACH ROW
    BEGIN
        INSERT INTO `PinNow`.`notification`(`follower`, `BeingFollowed`,`isPermitted`, `description` )
        VALUES(NEW.`follower`, NEW.`personBeingFollowed`,NEW.`isPermitted`, 'follow user');
    END;$$

DELIMITER;

DELIMITER $$

CREATE TRIGGER notifyUFB BEFORE INSERT ON `PinNow`.`user_follows_pinboard`
    FOR EACH ROW
    BEGIN
        INSERT INTO `PinNow`.`notification`(`follower`, `BeingFollowed`,`isPermitted`, `pinboards_name`, `description` )
        VALUES(NEW.`user_email`, NEW.`pinboards_user_email`,NEW.`isPermitted`,NEW.`pinboards_name`, 'follow pinboard');
    END;$$

DELIMITER;




SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
