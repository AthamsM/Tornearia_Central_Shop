package br.com.torneariacentralshop.api.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float rating;
	private String comment;
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Review() {
	}
	
	public Review(int id, float rating, String comment, Date createdAt, User user) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.createdAt = createdAt;
		this.user = user;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
