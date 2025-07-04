package br.com.torneariacentralshop.api.dtos;

import java.math.BigDecimal;

public record MercadoPagoDTO(
		String token,
		BigDecimal transactionAmount,
		String description,
		int installments,
		String paymentMethodId,
		String issuerId,
		String email,
		String cpf
		) {}
