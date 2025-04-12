package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.ImageProductDTO;
import br.com.torneariacentralshop.api.entities.ImageProduct;

public class ImageProductMapper {
	public static ImageProductDTO toDTO(ImageProduct imageProduct) {
		return new ImageProductDTO(imageProduct.getId(),imageProduct.getUrl());
	}
	
	public static ImageProduct toEntity(ImageProductDTO imageProductDTO) {
		ImageProduct imageProduct = new ImageProduct();
		imageProduct.setUrl(imageProductDTO.url());
		return imageProduct;
	}
}
