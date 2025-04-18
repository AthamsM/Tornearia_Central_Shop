package br.com.torneariacentralshop.api.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="carts")

public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Cart() {

	}
	
	public Cart(int id, User user) {
		this.id = id;
		this.user = user;
	}
	
	

	public int getId() {
		return id;
	}


	public User getUser() {
	    return user;
	}

	public void setUser(User user) {
	    this.user = user;
	}

}
