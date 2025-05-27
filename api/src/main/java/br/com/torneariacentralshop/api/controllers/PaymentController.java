package br.com.torneariacentralshop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.torneariacentralshop.api.dtos.PaymentDTO;
import br.com.torneariacentralshop.api.dtos.PaymentResponseDTO;
import br.com.torneariacentralshop.api.enums.PaymentStatus;
import br.com.torneariacentralshop.api.services.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<PaymentResponseDTO> createPayment(@RequestBody PaymentDTO paymentDTO){
		return new ResponseEntity<>(paymentService.createPayment(paymentDTO), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<PaymentResponseDTO> updatePayment(@RequestParam int id, @RequestParam PaymentStatus status){
		return new ResponseEntity<>(paymentService.UpdatePayment(id, status), HttpStatus.OK);
	}
}
