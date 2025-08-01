package br.com.torneariacentralshop.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.torneariacentralshop.api.entities.CartItem;

@Repository
public interface CartItemRepositoy extends JpaRepository<CartItem, Integer>{
	@Query(value = ("SELECT * FROM cart_items WHERE cart_id = :cart_id"), nativeQuery = true)
	List<CartItem> findByCart(@Param("cart_id")int cart_id);
	
	@Modifying
	@Query(value = ("DELETE FROM cart_items WHERE cart_id = :cart_id"), nativeQuery = true)
	void deleteCartItem(@Param("cart_id")int cart_id);
	
	@Modifying
	@Query(value = ("DELETE FROM cart_items WHERE id = :item_id"), nativeQuery = true)
	void deleteItemCart(@Param("item_id")int item_id);
	
	@Query(value = ("SELECT * FROM cart_items WHERE cart_id = :cart_id AND product_id = :product_id"), nativeQuery = true)
	CartItem findByCartIdAndProductId(@Param("cart_id")int cart_id, @Param("product_id")int product_id);
}
