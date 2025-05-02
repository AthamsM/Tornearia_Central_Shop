package br.com.torneariacentralshop.api.dtos;

import java.math.BigDecimal;


public record OrderDTO(
		int userId, 
		int paymentId,
		BigDecimal totalPrice
		) {}
