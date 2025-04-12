package br.com.torneariacentralshop.api.repository;




import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.torneariacentralshop.api.entities.Cart;
import br.com.torneariacentralshop.api.entities.CartItem;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	@Query(value = ("SELECT * FROM carts WHERE user_id = :user_id"), nativeQuery = true)
	Cart findByUser(@Param("user_id")int user_id);
	
	@Query(value = ("SELECT * FROM cart_items WHERE cart_id = :cart_id and product_id = :product_id"), nativeQuery = true)
	CartItem searchCartItemWithProducts(@Param("cart_id")int cart_id, @Param("product_id")int product_id);
	
	@Modifying
	@Query(value = ("INSERT INTO cart_items( quantity, subtotal, cart_id, product_id) VALUES (:quantity, :subtotal, :cart_id, :product_id)"), nativeQuery = true)
	void insertCartItem(@Param("quantity")int quantity, @Param("subtotal")BigDecimal subtotal, @Param("cart_id")int cart_id, @Param("product_id")int product_id);
	
	@Modifying
	@Query(value = ("UPDATE cart_items SET quantity = :quantity, subtotal = :subtotal WHERE id = :id "), nativeQuery = true)
	void updateCartItem(@Param("id")int id,@Param("quantity")int quantity, @Param("subtotal")BigDecimal subtotal);
	
	@Modifying
	@Query(value = ("DELETE FROM cart_items WHERE cart_id = :cart_id"), nativeQuery = true)
	void deleteCartItem(@Param("cart_id")int cartId);
	
	@Modifying
	@Query(value = ("DELETE FROM cart_items WHERE id = :id"), nativeQuery = true)
	void deleteItemCart(@Param("id")int id);
	
	@Query(value = ("SELECT * FROM cart_items WHERE id = :id"), nativeQuery = true)
	CartItem searchCartItem(@Param("id")int id);
	
	@Query(value = ("SELECT * FROM cart_items WHERE cart_id = :cart_id"), nativeQuery = true)
	List<CartItem> listCartItem(@Param("cart_id")int cart_id);
	
}
