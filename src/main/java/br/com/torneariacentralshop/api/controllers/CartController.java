//package br.com.torneariacentralshop.api.controllers;
//
//import java.math.BigDecimal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.torneariacentralshop.api.services.CartService;
//
//@RestController
//@RequestMapping("/api/carts")
//public class CartController {
//	
//	@Autowired
//	private CartService cartService;
//	
//	
//	@PostMapping("/{cartId}/addItem")
//	public ResponseEntity<String> addCart(@PathVariable int userId,@RequestParam int productId,@RequestParam int quantity){
//		cartService.addItem(productId, quantity, userId);
//		return ResponseEntity.ok("Item adicionado ao carrinho!");
//	}
//	
//	@GetMapping
//	public ResponseEntity<BigDecimal> getTotalPrice (int userId){
//		return new ResponseEntity<>(cartService.getTotalPrice(userId),  HttpStatus.OK);
//	}
//
//}
