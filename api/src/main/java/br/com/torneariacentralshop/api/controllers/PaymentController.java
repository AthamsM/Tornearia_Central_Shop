package br.com.torneariacentralshop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.resources.payment.Payment;

import br.com.torneariacentralshop.api.dtos.MercadoPagoDTO;
import br.com.torneariacentralshop.api.dtos.PaymentDTO;
import br.com.torneariacentralshop.api.dtos.PaymentResponseDTO;
import br.com.torneariacentralshop.api.enums.PaymentStatus;
import br.com.torneariacentralshop.api.services.PaymentService;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	
	@Value("${mp.key}") private String mpKey;
	
	@PostConstruct
	public void init() {
		MercadoPagoConfig.setAccessToken(mpKey);
	}
	
	@PostMapping("/pay")	
	public ResponseEntity<?> processPayment(@RequestBody MercadoPagoDTO mercadoPagoDTO){ 
		try {
			PaymentClient client = new PaymentClient();
			
			PaymentCreateRequest request = PaymentCreateRequest
					.builder()
					.transactionAmount(mercadoPagoDTO.transactionAmount())
					.token(mercadoPagoDTO.token())
					.description(mercadoPagoDTO.description())
					.installments(mercadoPagoDTO.installments())
					.paymentMethodId(mercadoPagoDTO.paymentMethodId())
					.issuerId(mercadoPagoDTO.issuerId())
					.payer(
							PaymentPayerRequest.builder()
							.email(mercadoPagoDTO.email())
							.identification(
									IdentificationRequest.builder()
									.type("CPF")
									.number(mercadoPagoDTO.cpf())
									.build()
									).build()
							).build();
			Payment payment = client.create(request);
			return ResponseEntity.status(HttpStatus.OK).body(payment);
		}catch (Exception e) {
			e.printStackTrace();
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao processar pagamento: " + e.getMessage());
		}
	}
	@PostMapping
	public ResponseEntity<PaymentResponseDTO> createPayment(@RequestBody PaymentDTO paymentDTO){
		return new ResponseEntity<>(paymentService.createPayment(paymentDTO), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<PaymentResponseDTO> updatePayment(@RequestParam int id, @RequestParam PaymentStatus status){
		return new ResponseEntity<>(paymentService.UpdatePayment(id, status), HttpStatus.OK);
	}
	
}
