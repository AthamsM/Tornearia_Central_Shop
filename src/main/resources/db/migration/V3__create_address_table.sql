CREATE TABLE addresses(
	id INT AUTO_INCREMENT PRIMARY KEY,
	place VARCHAR(255),
	number VARCHAR(255),
	complement VARCHAR(255),
	neighborhood VARCHAR(255),
	city VARCHAR(255),
	state VARCHAR(255),
	cep VARCHAR(255),
	userId INT NOT NULL,
	FOREIGN KEY (userId) REFERENCES users(id)
);