CREATE TABLE IF NOT EXISTS `users` (
    id bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(50) UNIQUE NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    account_non_expired bit(1) DEFAULT NULL,
	account_non_locked bit(1) DEFAULT NULL,
	credentials_non_expired bit(1) DEFAULT NULL,
	enabled bit(1) DEFAULT NULL
	
);
