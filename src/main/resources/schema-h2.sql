-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NOT NULL UNIQUE,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NULL,
  `email` VARCHAR(100) NOT NULL UNIQUE,
  `password_hash` VARCHAR(255) NOT NULL,
  `image_url` VARCHAR(256) NULL,
  `activated` TINYINT NOT NULL,
  `created_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `last_login_time` TIMESTAMP NULL,
  `activation_key` VARCHAR(20) NULL,
  `reset_key` VARCHAR(20) NULL,
  `reset_date` TIMESTAMP NULL,
  `last_modified_by` VARCHAR(50) NULL,
  `last_modified_date` TIMESTAMP NULL,
  PRIMARY KEY (`id`));



-- -----------------------------------------------------
-- Table `porra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `porra` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `external_id` VARCHAR(255) NOT NULL UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `creator_id` BIGINT NOT NULL,
  `type` VARCHAR(45) NOT NULL DEFAULT 'OPEN',
  `description` TEXT NULL,
  `image_url` VARCHAR(255) NULL,
  `valid` TINYINT NULL DEFAULT 0,
  `winner_bet` VARCHAR(255) NULL DEFAULT NULL,
  `winner_possible_bet` BIGINT NULL,
  `max_participants` INT NOT NULL,
  `finish_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_porra_creator_id`
    FOREIGN KEY (`creator_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `user_porra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_porra` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_user` BIGINT NOT NULL,
  `id_porra` BIGINT NOT NULL,
  `bet` VARCHAR(255) NULL DEFAULT NULL,
  `id_possible_bet` BIGINT NULL,
  `winned` TINYINT NULL DEFAULT 0,
  `paid` TINYINT NULL DEFAULT 0,
  `paid_time` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_porra_id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_porra_id_porra`
    FOREIGN KEY (`id_porra`)
    REFERENCES `porra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `user_friend`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_friend` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_user` BIGINT NOT NULL,
  `id_friend` BIGINT NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `active` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_friend_id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_friend_id_friend`
    FOREIGN KEY (`id_friend`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `role` (
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`name`));



-- -----------------------------------------------------
-- Table `user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_role` (
  `id_user` BIGINT NOT NULL,
  `role_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`role_name`, `id_user`),
  CONSTRAINT `fk_user_role_role_name`
    FOREIGN KEY (`role_name`)
    REFERENCES `role` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `possible_bet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `possible_bet` (
  `id` BIGINT NOT NULL,
  `id_porra` BIGINT NOT NULL,
  `bet` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_possible_bet_id_porra`
    FOREIGN KEY (`id_porra`)
    REFERENCES `porra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
