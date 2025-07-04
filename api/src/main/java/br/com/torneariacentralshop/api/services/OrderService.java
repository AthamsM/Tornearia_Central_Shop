package br.com.torneariacentralshop.api.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.dtos.CartItemResponseDTO;
import br.com.torneariacentralshop.api.dtos.OrderDTO;
import br.com.torneariacentralshop.api.dtos.OrderItemResponseDTO;
import br.com.torneariacentralshop.api.dtos.OrderResponseDTO;
import br.com.torneariacentralshop.api.dtos.ProductUpdateDTO;
import br.com.torneariacentralshop.api.entities.Cart;
import br.com.torneariacentralshop.api.entities.Order;
import br.com.torneariacentralshop.api.entities.OrderItem;
import br.com.torneariacentralshop.api.entities.Payment;
import br.com.torneariacentralshop.api.entities.Product;
import br.com.torneariacentralshop.api.entities.User;
import br.com.torneariacentralshop.api.enums.OrderStatus;
import br.com.torneariacentralshop.api.mappers.OrderItemMapper;
import br.com.torneariacentralshop.api.mappers.OrderMapper;
import br.com.torneariacentralshop.api.repository.CartRepository;
import br.com.torneariacentralshop.api.repository.OrderItemRepository;
import br.com.torneariacentralshop.api.repository.OrderRepositoy;
import br.com.torneariacentralshop.api.repository.PaymentRepository;
import br.com.torneariacentralshop.api.repository.ProductRepository;
import br.com.torneariacentralshop.api.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepositoy orderRepositoy;
	@Autowired
	private OrderItemRepository orderitemRepository;
	
	private UserRepository userRepository;
	private PaymentRepository paymentRepository;
	private CartRepository cartRepository;
	private ProductRepository productRepository;
	private CartService cartService;
	private ProductService productService;
	
	public OrderService(UserRepository userRepository, PaymentRepository paymentRepository, CartRepository cartRepository, ProductRepository productRepository, CartService cartService, ProductService productService) {
	        this.userRepository = userRepository;
	        this.paymentRepository = paymentRepository;
	        this.cartRepository = cartRepository;
	        this.productRepository = productRepository;
	        this.cartService = cartService;
	        this.productService = productService;
	}
	    
	@Transactional
	public OrderResponseDTO createOrder(OrderDTO orderDTO) {
		User user = userRepository.findById(orderDTO.userId()).orElseThrow(() -> new RuntimeException("Erro search User"));
		Payment payment = paymentRepository.findById(orderDTO.paymentId()).orElseThrow(() -> new RuntimeException("Error search Payment"));
		Order order = OrderMapper.toEntity(orderDTO);
		order.setUser(user);
		order.setPayment(payment);
		order.setTrackingCode(assingTrackingCode());
		orderRepositoy.save(order);
		insertOrderItem(order);
		return OrderMapper.toDTO(order);
	}
	
	@Transactional
	private void insertOrderItem(Order order) {
		Cart cart = cartRepository.findByUserId(order.getUser().getId());
		List<CartItemResponseDTO> cartItemDTO = cartService.getAllCartItem(order.getUser().getId());
		for(CartItemResponseDTO item: cartItemDTO) {
			Product product = productRepository.findById(item.product().id()).orElseThrow(() -> new RuntimeException("Error search Product"));
			ProductUpdateDTO  productUpdate = new ProductUpdateDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getRating(), product.getStock() - item.quantity()); 
			productService.updateProduct(productUpdate);
			OrderItem orderItem= new OrderItem(item.quantity(), item.subtotal(), order, product);
			orderitemRepository.save(orderItem);
			
		}
		cartService.deleteCartItem(cart.getId());
	}
	
	private String assingTrackingCode() {
		return "Teste-Tracking-Code";
	}
	
	public OrderResponseDTO updateOrder(int id, OrderStatus status){
		Order order = orderRepositoy.findById(id).orElseThrow(() -> new RuntimeException("Error search Order"));
		order.setStatus(status);
		return OrderMapper.toDTO(orderRepositoy.save(order));
	}
	
	public List<OrderResponseDTO> getAllOrder(int user_id){
		if (orderRepositoy.findAllByUserId(user_id) == null) {
			return null;
		}else {
			return orderRepositoy.findAllByUserId(user_id).stream().map(OrderMapper :: toDTO).toList();
		}
	}
	
	public List<OrderItemResponseDTO> getAllOrderItem(int order_id){
			return orderitemRepository.findAllByOrderId(order_id).stream().map(OrderItemMapper :: toDTO).toList();
	}
	
}
