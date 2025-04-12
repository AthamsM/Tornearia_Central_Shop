package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.CartItemResponseDTO;
import br.com.torneariacentralshop.api.entities.CartItem;
public class CartItemMapper {
	
	public static CartItemResponseDTO toDTO(CartItem cartItem) {
		return new CartItemResponseDTO(cartItem.getQuantity(), cartItem.getSubtotal(), ProductMapper.toDTO(cartItem.getProduct()));
	}
}
