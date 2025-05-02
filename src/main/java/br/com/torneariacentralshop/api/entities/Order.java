package br.com.torneariacentralshop.api.entities;

import java.math.BigDecimal;

import br.com.torneariacentralshop.api.enums.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private BigDecimal totalPrice;
	@Enumerated(EnumType.STRING)
	private OrderStatus status = OrderStatus.PROCESSING;
	private String trackingCode;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;


	public Order() {

	}
	
	public Order(BigDecimal totalPrice, OrderStatus status, String trackingCode, User user, Payment payment) {
		this.totalPrice = totalPrice;
		this.status = status;
		this.trackingCode = trackingCode;
		this.user = user;
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
