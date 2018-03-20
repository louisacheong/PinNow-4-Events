
-- -----------------------------------------------------
-- Table `PinNow`.`track_login`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PinNow`.`track_login` ;

CREATE TABLE IF NOT EXISTS `PinNow`.`track_login` (
  `id` MEDIUMINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `last_login` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`));

DROP PROCEDURE IF EXISTS login_trigger;

DELIMITER //

CREATE PROCEDURE PinNow.login_trigger()
BEGIN
    INSERT INTO PinNow.track_login (email, last_login) VALUES(USER(), CURRENT_TIMESTAMP());
END;

//
DELIMITER;

GRANT EXECUTE ON PinNow.login_trigger TO 'admin'@'%';

