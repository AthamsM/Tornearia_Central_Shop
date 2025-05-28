package br.com.torneariacentralshop.api.dtos;

import java.math.BigDecimal;

public record OrderItemResponseDTO(
		int id,
		ProductResponseDTO product,
		OrderResponseDTO order,
		int quantity,
		BigDecimal subtotal
		) {}
