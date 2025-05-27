CREATE TABLE orders(
	id INT AUTO_INCREMENT PRIMARY KEY,
	user_id INT NOT NULL,
	payment_id INT NOT NULL,
	total_price DECIMAL(10,2) NOT NULL,
	status VARCHAR(20) NOT NULL,
	tracking_code VARCHAR(255) NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(id),
	fOREIGN KEY (payment_id) REFERENCES payments(id)
);

CREATE TABLE order_items(
	id INT AUTO_INCREMENT PRIMARY KEY,
	product_id INT NOT NULL,
	order_id INT NOT NULL,
	quantity INT NOT NULL,
	subtotal DECIMAL(10,2) NOT NULL,
	FOREIGN KEY (product_id) REFERENCES products(id),
	FOREIGN KEY (order_id) REFERENCES orders(id)
);