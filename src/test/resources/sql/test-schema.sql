CREATE SCHEMA `exercise1` ;

CREATE TABLE `exercise1`.`users` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(255) NULL,
  `lastName` VARCHAR(255) NULL,
  `address` VARCHAR(255) NULL,
  PRIMARY KEY (`userid`));

CREATE TABLE `exercise1`.`students` (
  `userId` INT NOT NULL,
  `grade` VARCHAR(255) NULL,
  `average` INT NULL,
  INDEX `userId_idx` (`userId` ASC) VISIBLE,
  CONSTRAINT `userId`
    FOREIGN KEY (`userId`)
    REFERENCES `exercise1`.`users` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
