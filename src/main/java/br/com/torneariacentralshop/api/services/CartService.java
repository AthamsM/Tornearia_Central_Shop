//package br.com.torneariacentralshop.api.services;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import br.com.torneariacentralshop.api.entities.Cart;
//import br.com.torneariacentralshop.api.entities.CartItem;
//import br.com.torneariacentralshop.api.entities.Product;
//import br.com.torneariacentralshop.api.entities.User;
//import br.com.torneariacentralshop.api.repository.CartItemRepositoy;
//import br.com.torneariacentralshop.api.repository.CartRepository;
//import br.com.torneariacentralshop.api.repository.ProductRepository;
//import br.com.torneariacentralshop.api.repository.UserRepository;
//
//@Service
//public class CartService {
//
//	@Autowired
//	private CartRepository cartRepository;
//	@Autowired
//	private CartItemRepositoy cartItemRepositoy;
//	@Autowired
//	private ProductRepository productRepository;
//	@Autowired
//	private UserRepository userRepository;
//	
//	
//	public void addItem(int productId, int quantity, int userId) {
//		User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
//		// buscar o carrinho do usuário ou criar um novo
//        Cart cart = cartRepository.byUser(user)
//                .orElseGet(() -> createCartUser(user));
//
//        // buscar o produto
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
//        // verificar se existem item nesse carrinho
//        CartItem existingItem = cartItemRepositoy.findByCartAndProduct(cart, product);
//        
//        if(existingItem != null) { // se SIM
//        	existingItem.setQuantity(existingItem.getQuantity() + quantity);
//        }else { // se NAO
//        	BigDecimal subPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
//        	CartItem cartItem = new CartItem(subPrice, quantity, cart, product);
//        	cartItemRepositoy.save(cartItem);
//        }
//	}
//	
//	public void removeItemCart(int cartItemId) {
//		CartItem cartItem = cartItemRepositoy.findById(cartItemId)
//						.orElseThrow(() -> new RuntimeException("Item não encontrado"));
//		cartItemRepositoy.delete(cartItem);
//	}
//	
//	public void updateItemCart(int cartItemId, int quantity, int productId) {
//		Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
//		CartItem cart = cartItemRepositoy.findById(cartItemId)
//				.orElseThrow(() -> new RuntimeException("Item não encontrado"));
//		BigDecimal newSubPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
//		newSubPrice = cart.getSubtotal().subtract(newSubPrice);
//		cart.setQuantity(cart.getQuantity() - quantity);
//		cart.setSubtotal(newSubPrice);
//	}
//	
//	public BigDecimal getTotalPrice(int userId){
//		User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
//		Cart cart = cartRepository.byUser(user)
//                .orElseGet(() -> createCartUser(user));
//		List<CartItem> cartItems = cartItemRepositoy.findByCart(cart);
//		
//		BigDecimal total = BigDecimal.ZERO;
//	    for (CartItem item : cartItems) {
//	        BigDecimal aux = item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
//	        total = total.add(aux       );
//	    }
//	    return total;
//	}
//	private Cart createCartUser(User user) {
//        Cart newCart = new Cart();
//        newCart.setUser(user);
//        return cartRepository.save(newCart);
//    }
//	
//}
