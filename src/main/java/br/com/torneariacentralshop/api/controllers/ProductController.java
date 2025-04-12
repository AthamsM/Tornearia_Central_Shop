package br.com.torneariacentralshop.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.torneariacentralshop.api.dtos.ProductDTO;
import br.com.torneariacentralshop.api.dtos.ProductResponseDTO;
import br.com.torneariacentralshop.api.entities.Product;
import br.com.torneariacentralshop.api.services.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDTO) {
		return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody Product product){
		return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable(name = "id")int id){
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDTO> readProduct(@PathVariable(name = "id")int id){
		return new ResponseEntity<>(productService.readProduct(id), HttpStatus.OK);
	}
	
	@GetMapping
	public List<ProductResponseDTO> ListAll(){
		return productService.readProductAll();
	}
}
