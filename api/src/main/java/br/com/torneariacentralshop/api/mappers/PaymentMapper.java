package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.PaymentDTO;
import br.com.torneariacentralshop.api.dtos.PaymentResponseDTO;
import br.com.torneariacentralshop.api.entities.Payment;

public class PaymentMapper {
	
	public static PaymentResponseDTO toDTO(Payment payment) {
		return new PaymentResponseDTO(payment.getId(), UserMapper.toDTO(payment.getUser()), payment.getPaymentMethod(), payment.getAmount(), payment.getStatus());
	}
	
	public static Payment toEntity(PaymentDTO paymentDTO ) {
		Payment payment = new Payment();
		payment.setPaymentMethod(paymentDTO.paymentMethod());
		payment.setAmount(paymentDTO.amount());
		return payment;
	}
}
