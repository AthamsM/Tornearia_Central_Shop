package br.com.torneariacentralshop.api.dtos;

import java.math.BigDecimal;

import br.com.torneariacentralshop.api.enums.PaymentMethod;

public record PaymentDTO(
		int userId,
		PaymentMethod paymentMethod,
		BigDecimal amount
		) {}
