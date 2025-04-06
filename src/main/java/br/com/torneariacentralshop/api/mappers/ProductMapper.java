package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.ProductDTO;
import br.com.torneariacentralshop.api.dtos.ProductResponseDTO;
import br.com.torneariacentralshop.api.entities.Product;

public class ProductMapper {
	
	public static ProductResponseDTO toDTO(Product product){
		return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getRating(), product.getStock());		
	}
	public static Product toEntity(ProductDTO productDTO) {
		
		Product product = new Product();
		product.setName(productDTO.name());
		product.setDescription(productDTO.description());
		product.setPrice(productDTO.price());
		product.setStock(productDTO.stock());
		return product;
	}

}
