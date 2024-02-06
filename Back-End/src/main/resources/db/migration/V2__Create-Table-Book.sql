CREATE TABLE tb_book(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	author VARCHAR(255),
	total_pages SMALLINT,
	current_page SMALLINT DEFAULT 0,
	readingStatus ENUM('READ','READING','WISHLIST') NOT NULL,
	product_link varchar(255),
	user_id INT
	

);