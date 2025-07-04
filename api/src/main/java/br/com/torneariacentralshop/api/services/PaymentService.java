package br.com.torneariacentralshop.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.dtos.PaymentDTO;
import br.com.torneariacentralshop.api.dtos.PaymentResponseDTO;
import br.com.torneariacentralshop.api.entities.Payment;
import br.com.torneariacentralshop.api.entities.User;
import br.com.torneariacentralshop.api.enums.PaymentStatus;
import br.com.torneariacentralshop.api.mappers.PaymentMapper;
import br.com.torneariacentralshop.api.repository.PaymentRepository;
import br.com.torneariacentralshop.api.repository.UserRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	private UserRepository userRepository;
	
	public PaymentService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public PaymentResponseDTO createPayment(PaymentDTO paymentDTO) {
		User user = userRepository.findById(paymentDTO.userId()).orElseThrow(() -> new RuntimeException("Error search User"));
		Payment payment = PaymentMapper.toEntity(paymentDTO);
		payment.setUser(user);
		payment.setStatus(PaymentStatus.FINALIZED);
		return PaymentMapper.toDTO(paymentRepository.save(payment));
	}
	
	public PaymentResponseDTO UpdatePayment(int id, PaymentStatus status) {
		Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Erro search Payment"));
		payment.setStatus(status);
		return PaymentMapper.toDTO(paymentRepository.save(payment));
	}


}
