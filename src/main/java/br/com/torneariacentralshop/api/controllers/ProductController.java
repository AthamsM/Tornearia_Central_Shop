package br.com.torneariacentralshop.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.torneariacentralshop.api.dtos.ProductDTO;
import br.com.torneariacentralshop.api.dtos.ProductResponseDTO;
import br.com.torneariacentralshop.api.services.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDTO) {
		return new ResponseEntity<>(productService.store(productDTO), HttpStatus.CREATED);
	}
	 
	@GetMapping
	public List<ProductResponseDTO> ListAll(){
		return productService.getAll();
	}
}
