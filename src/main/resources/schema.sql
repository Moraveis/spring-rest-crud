DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT primary key,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL
);