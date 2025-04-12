package br.com.torneariacentralshop.api.dtos;

import java.math.BigDecimal;

import br.com.torneariacentralshop.api.entities.User;

public record OrderDTO(
		User user_id, 
		BigDecimal totalPrice
		) {

}
