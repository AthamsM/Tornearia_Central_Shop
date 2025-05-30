package br.com.torneariacentralshop.api.entities;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")

public class User implements UserDetails
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	//@CreatedDate
	//private Instant createdAt;
	//@LastModifiedBy
	//private Instant updatedAt;
	
	public User() {
	}
	
	public User(int id, String name, String email, String password, Instant createdAt, Instant updatedAt) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		//this.createdAt = createdAt;
		//this.updatedAt = updatedAt;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public Instant getCreatAt() {
//		return createdAt;
//	}
//	public void setCreatAt(Instant createdAt) {
//		this.createdAt = createdAt;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getEmail();
	}

//	public Instant getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Instant updatedAt) {
//		this.updatedAt = updatedAt;
//	}
}
