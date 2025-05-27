package br.com.torneariacentralshop.api.entities;

import java.math.BigDecimal;

import br.com.torneariacentralshop.api.enums.PaymentMethod;
import br.com.torneariacentralshop.api.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")

public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	private BigDecimal amount;
	@Enumerated(EnumType.STRING)
	private PaymentStatus status = PaymentStatus.INPROCESSING;
	//private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	

	public Payment() {

	}
	
	public Payment(PaymentMethod paymentMethod, BigDecimal amount,PaymentStatus paymentStatus,
			User user) {
		this.paymentMethod = paymentMethod;
		this.amount = amount;
		this.status = paymentStatus;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
