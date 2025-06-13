package br.com.torneariacentralshop.api.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.dtos.CartItemResponseDTO;
import br.com.torneariacentralshop.api.entities.Cart;
import br.com.torneariacentralshop.api.entities.CartItem;
import br.com.torneariacentralshop.api.entities.Product;
import br.com.torneariacentralshop.api.entities.User;
import br.com.torneariacentralshop.api.mappers.CartItemMapper;
import br.com.torneariacentralshop.api.repository.CartItemRepositoy;
import br.com.torneariacentralshop.api.repository.CartRepository;
import br.com.torneariacentralshop.api.repository.ProductRepository;
import br.com.torneariacentralshop.api.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartItemRepositoy cartItemRepositoy;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	
	public CartItemResponseDTO insertCartItem(int user_id, int product_id, int quantity) {
		User user = userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("Error search User"));
		Product product = productRepository.findById(product_id).orElseThrow(() -> new RuntimeException("Error serch Product"));
		Cart cart = cartRepository.findByUserId(user_id);
		if(cart == null) {
			cart = createCartToUser(user);
		}
		CartItem cartItem = cartItemRepositoy.findByCartIdAndProductId(cart.getId(), product_id);
		if(cartItem == null) {
			cartItem = new CartItem(product.getPrice().multiply(BigDecimal.valueOf(quantity)), quantity, cart, product);
		}else {
			cartItem.setQuantity(cartItem.getQuantity() + quantity);
			cartItem.setSubtotal(cartItem.getSubtotal().add(product.getPrice().multiply(BigDecimal.valueOf(quantity))));
		}
		
		if(product.getStock() < cartItem.getQuantity()) {
			throw new RuntimeException("There is not enough quantity in stock") ;
		}
		return CartItemMapper.toDTO(cartItemRepositoy.save(cartItem));
	}
	
	private Cart createCartToUser(User user) {
		Cart newCart = new Cart();
		newCart.setUser(user);
		return cartRepository.save(newCart);
	}
	
	@Transactional
	public CartItemResponseDTO updateCartItem(int cartItem_id, int quantity) {
		CartItem cartItem = cartItemRepositoy.findById(cartItem_id).orElseThrow(()-> new RuntimeException("Error search CartItem"));
		cartItem.setQuantity(cartItem.getQuantity() + quantity);
		if(cartItem.getQuantity() == 0) {
			cartItemRepositoy.delete(cartItem);
			return null;
		}
		if(quantity > 0) {
			cartItem.setSubtotal(cartItem.getSubtotal().add(cartItem.getProduct().getPrice()));			
		}else {
			cartItem.setSubtotal(cartItem.getSubtotal().subtract(cartItem.getProduct().getPrice()));
		}
		return CartItemMapper.toDTO(cartItemRepositoy.save(cartItem));
	}
	
	@Transactional
	public String deleteCartItem(int cart_id) {
		cartItemRepositoy.deleteCartItem(cart_id);
		return"deletado";
	}
	
	@Transactional
	public String deleteItemCart(int item_id) {
		cartItemRepositoy.deleteItemCart(item_id);
		return"deletado";
	}
	
	public BigDecimal getTotalPrice(int cart_id) {
		List<CartItem> cartItem = cartItemRepositoy.findByCart(cart_id);
		
		BigDecimal total = BigDecimal.ZERO;
		for(CartItem item : cartItem) {
			BigDecimal aux = item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
			total = total.add(aux);
		}
		return total;
	}
	
	public List<CartItemResponseDTO> getAllCartItem(int cart_id){
		return cartItemRepositoy.findByCart(cart_id).stream().map(CartItemMapper :: toDTO).toList();
	}
}
