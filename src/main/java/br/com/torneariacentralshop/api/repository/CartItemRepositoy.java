package br.com.torneariacentralshop.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.torneariacentralshop.api.entities.Cart;
import br.com.torneariacentralshop.api.entities.CartItem;
import br.com.torneariacentralshop.api.entities.Product;

@Repository
public interface CartItemRepositoy extends JpaRepository<CartItem, Integer>  {
	//CartItem findByCartAndProduct(Cart cartId, Product productId);
	//List<CartItem> findByCart(Cart cartId);
}
