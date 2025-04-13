package br.com.torneariacentralshop.api.dtos;

import java.math.BigDecimal;

public record CartItemResponseDTO(
		int quantity, 
		BigDecimal subtotal,
		ProductResponseDTO product
		) {}
