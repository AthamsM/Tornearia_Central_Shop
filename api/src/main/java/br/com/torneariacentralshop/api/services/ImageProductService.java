package br.com.torneariacentralshop.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.dtos.ImageProductDTO;
import br.com.torneariacentralshop.api.entities.ImageProduct;
import br.com.torneariacentralshop.api.entities.Product;
import br.com.torneariacentralshop.api.mappers.ImageProductMapper;
import br.com.torneariacentralshop.api.repository.ImageProductRepository;
import br.com.torneariacentralshop.api.repository.ProductRepository;

@Service
public class ImageProductService {
	@Autowired
	private ImageProductRepository imageProductRepository;

	private ProductRepository productRepository;
	
	public ImageProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ImageProductDTO createImageToProduct(ImageProductDTO imageProductDTO) {
		Product product = productRepository.findById(imageProductDTO.id()).orElseThrow(() -> new RuntimeException("Error search Product"));
		ImageProduct imageProduct = new ImageProduct(imageProductDTO.url(), product);
		imageProductRepository.save(imageProduct);
		return ImageProductMapper.toDTO(imageProduct);
	}
	
	public boolean deleteImageToProduct(int image_id) {
		ImageProduct imageProduct = imageProductRepository.findById(image_id).orElseThrow(() -> new RuntimeException("Error search Image"));
		imageProductRepository.delete(imageProduct);
		return true;
	}
	
	public List<ImageProductDTO> readImageToProduct(int product_id){
		return imageProductRepository.listImagetoProduct(product_id).stream().map(ImageProductMapper::toDTO).toList();
	}
	
}
