package br.com.torneariacentralshop.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.dtos.ProductDTO;
import br.com.torneariacentralshop.api.dtos.ProductResponseDTO;
import br.com.torneariacentralshop.api.entities.Product;
import br.com.torneariacentralshop.api.mappers.ProductMapper;
import br.com.torneariacentralshop.api.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public ProductResponseDTO store(ProductDTO productDTO){
		Product product = ProductMapper.toEntity(productDTO);
		productRepository.save(product);
		return ProductMapper.toDTO(product);
	}
	
	public List<ProductResponseDTO> getAll()
	{
		return productRepository.findAll().stream().map(ProductMapper::toDTO).toList();
	}
}
