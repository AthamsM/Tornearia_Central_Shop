package br.com.torneariacentralshop.api.dtos;

import java.math.BigDecimal;

public record CartItemResponseDTO(
		CartResponseDTO cart,
		int quantity, 
		BigDecimal subtotal,
		ProductResponseDTO product
		) {}
