
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `author_id` BIGINT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `price` DOUBLE NOT NULL,
  `launch_date` DATE NOT NULL,
  `user_id` BIGINT,
  FOREIGN KEY (`author_id`) REFERENCES `authors`(`id`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
  PRIMARY KEY (`id`)
);
