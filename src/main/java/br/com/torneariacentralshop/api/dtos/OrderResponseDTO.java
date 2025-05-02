package br.com.torneariacentralshop.api.dtos;


import br.com.torneariacentralshop.api.enums.OrderStatus;

public record OrderResponseDTO(
		int id,
		PaymentResponseDTO payment,
		OrderStatus status, 
		String trackingCode
		) {}
