package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.OrderDTO;
import br.com.torneariacentralshop.api.dtos.OrderResponseDTO;
import br.com.torneariacentralshop.api.entities.Order;

public class OrderMapper {
	
	public static OrderResponseDTO toDTO(Order order) {
		return new OrderResponseDTO(order.getId(), PaymentMapper.toDTO(order.getPayment()), order.getStatus(), order.getTrackingCode());
	}

	public static Order toEntity(OrderDTO orderDTO) {
		Order order = new Order();
		order.setTotalPrice(orderDTO.totalPrice());
		return order;
	}
}
