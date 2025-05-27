package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.CartResponseDTO;
import br.com.torneariacentralshop.api.entities.Cart;

public class CartMapper {

	public static CartResponseDTO toDTO(Cart cart) {
		return new CartResponseDTO(cart.getId(), UserMapper.toDTO(cart.getUser()));
	}
}
