package br.com.torneariacentralshop.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.torneariacentralshop.api.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	@Query(value = ("SELECT * FROM carts WHERE user_id = :user_id"), nativeQuery = true)
	Cart findByUser(@Param("user_id")int user_id);
}
