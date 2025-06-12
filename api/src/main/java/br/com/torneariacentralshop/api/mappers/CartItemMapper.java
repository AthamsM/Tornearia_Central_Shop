package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.CartItemResponseDTO;
import br.com.torneariacentralshop.api.entities.CartItem;
public class CartItemMapper {
	
	public static CartItemResponseDTO toDTO(CartItem cartItem) {
		return new CartItemResponseDTO(CartMapper.toDTO(cartItem.getCart()), cartItem.getId(), cartItem.getQuantity(), cartItem.getSubtotal(), ProductMapper.toDTO(cartItem.getProduct()));
	}
	
	public static CartItem toEntity(CartItemResponseDTO cartDTO) {
		CartItem cartItem = new CartItem();
		cartItem.setSubtotal(cartDTO.subtotal());
		cartItem.setQuantity(cartDTO.quantity());
		return cartItem;
	}
}
