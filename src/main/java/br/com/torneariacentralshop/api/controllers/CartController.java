package br.com.torneariacentralshop.api.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.torneariacentralshop.api.dtos.CartItemResponseDTO;
import br.com.torneariacentralshop.api.services.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/{user_id}")
	public ResponseEntity<CartItemResponseDTO> addCartItem(@PathVariable(name = "user_id")int user_id, @RequestParam int product_id, @RequestParam int quantity){
		return new ResponseEntity<>(cartService.insertCartItem(user_id, product_id, quantity), HttpStatus.OK);
	}
	
	@PutMapping("/{cartItem_id}")
	public ResponseEntity<CartItemResponseDTO> updateCartItem(@PathVariable(name = "cartItem_id")int cartItem_id, @RequestParam int quantity){
		return new ResponseEntity<>(cartService.updateCartItem(cartItem_id, quantity), HttpStatus.OK);
	}
	
	@DeleteMapping("{user_id}")
	public ResponseEntity<String> deleteCartItem(@PathVariable(name = "user_id")int user_id){
		return new ResponseEntity<>(cartService.deleteCartItem(user_id), HttpStatus.OK);
	}
	
	@GetMapping("{user_id}")
	public ResponseEntity<BigDecimal> getTotalPrice (@PathVariable(name = "user_id")int user_id){
		return new ResponseEntity<>(cartService.getTotalPrice(user_id),  HttpStatus.OK);
	}
	
	@GetMapping("/items/{cart_id}")
	public ResponseEntity<List<CartItemResponseDTO>> getAllCartItem(@PathVariable(name = "cart_id")int cart_id){
		return new ResponseEntity<>(cartService.getAllCartItem(cart_id), HttpStatus.OK);
	}
}
