package br.com.torneariacentralshop.api.dtos;

import java.math.BigDecimal;

import br.com.torneariacentralshop.api.enums.PaymentMethod;
import br.com.torneariacentralshop.api.enums.PaymentStatus;

public record PaymentResponseDTO(
		int id,
		UserResponseDTO user,
		PaymentMethod paymentMethod,
		BigDecimal amount,
		PaymentStatus status
		) {}
