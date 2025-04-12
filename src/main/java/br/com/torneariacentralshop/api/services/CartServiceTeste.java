package br.com.torneariacentralshop.api.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.entities.Cart;
import br.com.torneariacentralshop.api.entities.CartItem;
import br.com.torneariacentralshop.api.entities.Product;
import br.com.torneariacentralshop.api.entities.User;
import br.com.torneariacentralshop.api.repository.CartRepository;
import br.com.torneariacentralshop.api.repository.ProductRepository;
import br.com.torneariacentralshop.api.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class CartServiceTeste {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public CartItem createCartItem(int user_id,  int product_id, int quantity) {
		User user = userRepository.findById(user_id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		System.out.println(user_id);
		// buscar o carrinho do usuário ou criar um novo
        Cart cart = cartRepository.findByUser(user_id);
        if (cart == null) {
        	createCartUser(user);
        }

        // buscar o produto
        Product product = productRepository.findById(product_id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        
        // verificar se existem o item nesse carrinho
        CartItem existingItem = cartRepository.searchCartItemWithProducts(cart.getId(), product.getId());
        
        if(product.getStock() >= quantity) {
	        if(existingItem != null) { // se SIM
	        	BigDecimal subPrice = existingItem.getSubtotal().add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
	        	existingItem.setQuantity(existingItem.getQuantity() + quantity);
	        	existingItem.setSubtotal(subPrice);
	        }else { // se NAO
	        	BigDecimal subPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
	        	System.out.println(subPrice);
	        	CartItem cartItem = new CartItem(subPrice, quantity, cart, product);
	        	System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	        	System.out.println(cartItem.getSubtotal());
	        	cartRepository.insertCartItem(cartItem.getQuantity(), cartItem.getSubtotal(), cart.getId(), product_id);
	        	return cartItem;
	        }
        }else {
        	System.out.println("Nao tem mais itemmmmmmmmmmm");
        }
        return existingItem;
	}
	
	@Transactional
	public String deleteCartItem(int user_id) {
		Cart cart = cartRepository.findByUser(user_id);
				//.orElseThrow(() -> new RuntimeException("Error search Cart"));
		cartRepository.deleteCartItem(cart.getId());	
		return "ok";
	}
	
	@Transactional
	public CartItem updateItemCart(int cartItem_id, int quantity) {
		CartItem cartItem = cartRepository.searchCartItem(cartItem_id);
		Product product = cartItem.getProduct();
		if(product.getStock() >= quantity) {
			cartItem.setQuantity(quantity);
			if(quantity == 0) {
				cartRepository.deleteItemCart(cartItem_id);
			}else {
				BigDecimal subPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
				cartItem.setSubtotal(subPrice);	
				cartRepository.updateCartItem(cartItem_id, quantity, subPrice);
			}
		}else {
			System.out.println("Nao tem mais itemmmmmmmmmmm");
		}
		return cartItem;
	}
	
	public BigDecimal getTotalPrice(int user_id){
		Cart cart = cartRepository.findByUser(user_id);
                //.orElseThrow(() -> new RuntimeException("Error search Cart"));
		
		List<CartItem> cartItems = cartRepository.listCartItem(cart.getId());
		
		BigDecimal total = BigDecimal.ZERO;
	    for (CartItem item : cartItems) {
	        BigDecimal aux = item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
	        total = total.add(aux       );
	    }
	    return total;
	}
	private Cart createCartUser(User user) {
        Cart newCart = new Cart();
        newCart.setUser(user);
        System.out.println("AQUIIIIIIIIIIIIIIIIIII");
        return cartRepository.save(newCart);
    }
	
}
