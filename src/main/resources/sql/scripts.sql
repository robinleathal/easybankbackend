CREATE database easybankdb;
use easybankdb;

CREATE TABLE `easybankdb`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `easybankdb`.`authorities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `authority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


INSERT INTO easybankdb.users VALUES (NULL, 'happy', '12345', '1');
INSERT INTO easybankdb.authorities VALUES (NULL, 'happy', 'write');

SELECT * FROM easybankdb.authorities;
SELECT * FROM easybankdb.users;