package br.com.torneariacentralshop.api.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartItems")

public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private BigDecimal subtotal;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;	
}
