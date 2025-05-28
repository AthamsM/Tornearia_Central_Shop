package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.OrderItemResponseDTO;
import br.com.torneariacentralshop.api.entities.OrderItem;

public class OrderItemMapper {

	public static OrderItemResponseDTO toDTO(OrderItem orderItem) {
		return new OrderItemResponseDTO(orderItem.getId(), ProductMapper.toDTO(orderItem.getProduct()), OrderMapper.toDTO(orderItem.getOrder()), orderItem.getQuantity(), orderItem.getSubtotal());
	}
}
