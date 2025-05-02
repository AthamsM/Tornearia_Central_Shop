package br.com.torneariacentralshop.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.dtos.ProductDTO;
import br.com.torneariacentralshop.api.dtos.ProductResponseDTO;
import br.com.torneariacentralshop.api.dtos.ProductUpdateDTO;
import br.com.torneariacentralshop.api.entities.Product;
import br.com.torneariacentralshop.api.mappers.ProductMapper;
import br.com.torneariacentralshop.api.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public ProductResponseDTO createProduct(ProductDTO productDTO){
		Product product = ProductMapper.toEntity(productDTO);
		return ProductMapper.toDTO(productRepository.save(product));
	}
	
	public ProductResponseDTO updateProduct(ProductUpdateDTO updateProductDTO) {
		
		Product product = productRepository.findById(updateProductDTO.id()).orElseThrow(() -> new RuntimeException("error search product"));
		product.setName(updateProductDTO.name());
		product.setDescription(updateProductDTO.description());
		product.setPrice(updateProductDTO.price());
		product.setStock(updateProductDTO.stock());
		productRepository.save(product);
		return ProductMapper.toDTO(product);
			
	}
	
	public boolean deleteProduct(int productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("error search product"));
		productRepository.delete(product);
		return true;
	}
	
	public ProductResponseDTO readProduct(int productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("error search product"));
		return ProductMapper.toDTO(product);
	}

	
	public List<ProductResponseDTO> readProductAll(){
		return productRepository.findAll().stream().map(ProductMapper::toDTO).toList();
	}
}
