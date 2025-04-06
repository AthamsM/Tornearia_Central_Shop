package br.com.torneariacentralshop.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.torneariacentralshop.api.entities.Cart;
import br.com.torneariacentralshop.api.entities.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	//Optional<Cart> byUser(User userId);
}
