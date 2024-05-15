/*-- portfolio.job_type definition

CREATE TABLE `job_type` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `create_at` datetime(6) NOT NULL,
                            `update_at` datetime(6) DEFAULT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- portfolio.template definition

CREATE TABLE `template` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `create_at` datetime(6) NOT NULL,
                            `update_at` datetime(6) DEFAULT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `template` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- portfolio.users definition

CREATE TABLE `users` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `create_at` datetime(6) NOT NULL,
                         `update_at` datetime(6) DEFAULT NULL,
                         `email` varchar(255) DEFAULT NULL,
                         `password` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- portfolio.company definition

CREATE TABLE `company` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `create_at` datetime(6) NOT NULL,
                           `update_at` datetime(6) DEFAULT NULL,
                           `hire_date` date NOT NULL,
                           `logo_path` varchar(255) DEFAULT NULL,
                           `name` varchar(255) DEFAULT NULL,
                           `quit_date` date DEFAULT NULL,
                           `user_id` bigint DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FKs25gg17r6n7ubxe30ou6c6uap` (`user_id`),
                           CONSTRAINT `FKs25gg17r6n7ubxe30ou6c6uap` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- portfolio.job definition

CREATE TABLE `job` (
                       `id` bigint NOT NULL AUTO_INCREMENT,
                       `create_at` datetime(6) NOT NULL,
                       `update_at` datetime(6) DEFAULT NULL,
                       `name` varchar(255) DEFAULT NULL,
                       `job_type_id` bigint DEFAULT NULL,
                       PRIMARY KEY (`id`),
                       KEY `FKby5kmudqp9ee4baa93rlmoieg` (`job_type_id`),
                       CONSTRAINT `FKby5kmudqp9ee4baa93rlmoieg` FOREIGN KEY (`job_type_id`) REFERENCES `job_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- portfolio.job_skill definition

CREATE TABLE `job_skill` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `create_at` datetime(6) NOT NULL,
                             `update_at` datetime(6) DEFAULT NULL,
                             `name` varchar(255) DEFAULT NULL,
                             `job_id` bigint DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `FK9ix4wg520ii2gu2felxdhdup6` (`job_id`),
                             CONSTRAINT `FK9ix4wg520ii2gu2felxdhdup6` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- portfolio.portfolio definition

CREATE TABLE `portfolio` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `create_at` datetime(6) NOT NULL,
                             `update_at` datetime(6) DEFAULT NULL,
                             `content` varchar(255) DEFAULT NULL,
                             `name` varchar(255) DEFAULT NULL,
                             `end_at` date DEFAULT NULL,
                             `start_at` date DEFAULT NULL,
                             `title` varchar(255) DEFAULT NULL,
                             `company_id` bigint DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `FK85931pklvjkgtuf2e1rfsx1o6` (`company_id`),
                             CONSTRAINT `FK85931pklvjkgtuf2e1rfsx1o6` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- portfolio.portfolio_job_skill definition

CREATE TABLE `portfolio_job_skill` (
                                       `create_at` datetime(6) NOT NULL,
                                       `update_at` datetime(6) DEFAULT NULL,
                                       `portfolio_id` bigint NOT NULL,
                                       `job_skill_id` bigint NOT NULL,
                                       PRIMARY KEY (`job_skill_id`,`portfolio_id`),
                                       KEY `FK9ugsgg202aueidcudj5g1iw1p` (`portfolio_id`),
                                       CONSTRAINT `FK3pj81xrjiefsa9wn582taetgu` FOREIGN KEY (`job_skill_id`) REFERENCES `job_skill` (`id`),
                                       CONSTRAINT `FK9ugsgg202aueidcudj5g1iw1p` FOREIGN KEY (`portfolio_id`) REFERENCES `portfolio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- portfolio.user_job definition

CREATE TABLE `user_job` (
                            `create_at` datetime(6) NOT NULL,
                            `update_at` datetime(6) DEFAULT NULL,
                            `job_id` bigint NOT NULL,
                            `users_id` bigint NOT NULL,
                            PRIMARY KEY (`job_id`,`users_id`),
                            KEY `FKg4tq2lwi062my4xy4xdl52a1` (`users_id`),
                            CONSTRAINT `FKg4tq2lwi062my4xy4xdl52a1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`),
                            CONSTRAINT `FKia2o1pm0plymfbt26ps56ox5l` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;*/