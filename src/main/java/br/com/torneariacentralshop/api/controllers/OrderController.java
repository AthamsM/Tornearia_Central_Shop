package br.com.torneariacentralshop.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.torneariacentralshop.api.dtos.OrderDTO;
import br.com.torneariacentralshop.api.dtos.OrderItemResponseDTO;
import br.com.torneariacentralshop.api.dtos.OrderResponseDTO;
import br.com.torneariacentralshop.api.enums.OrderStatus;
import br.com.torneariacentralshop.api.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderResponseDTO> creteOrder(@RequestBody OrderDTO orderDTO){
		return new ResponseEntity<>(orderService.createOrder(orderDTO), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<OrderResponseDTO> createOrder(@RequestParam int id, @RequestParam OrderStatus status){
		return new ResponseEntity<>(orderService.updateOrder(id, status), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<OrderResponseDTO>> getAllOrder(@PathVariable(name = "id") int id){
		return new ResponseEntity<>(orderService.getAllOrder(id), HttpStatus.OK);
	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<List<OrderItemResponseDTO>> getAllOrdeItem(@PathVariable(name = "id") int id){
		return new ResponseEntity<>(orderService.getAllOrderItem(id), HttpStatus.OK);
	}
	
}
