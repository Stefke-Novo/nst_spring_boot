CREATE TABLE IF NOT EXISTS `member` (
  `id` bigint unsigned NOT NULL  AUTO_INCREMENT,
  `department_id` bigint unsigned NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `education_title_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`,`department_id`),
)
