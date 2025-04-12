CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
);

CREATE TABLE addresses(
	id INT AUTO_INCREMENT PRIMARY KEY,
	place VARCHAR(255),
	number VARCHAR(255),
	complement VARCHAR(255),
	neighborhood VARCHAR(255),
	city VARCHAR(255),
	state VARCHAR(255),
	cep VARCHAR(255),
	user_id INT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);