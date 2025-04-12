package br.com.torneariacentralshop.api.entities;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordes")

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private BigDecimal totalPrice;
	private String status;
	private String trackingCode;
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Order() {

	}
	
	public Order(int id, BigDecimal totalPrice, String status, String paymentMethod, String trackingCode,
			Date createdAt, User user) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.status = status;
		this.trackingCode = trackingCode;
		this.createdAt = createdAt;
		this.user = user;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public Date getCreatAt() {
		return createdAt;
	}

	public void setCreatAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
