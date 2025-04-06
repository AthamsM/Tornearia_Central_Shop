package br.com.torneariacentralshop.api.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.dtos.OrderDTO;
import br.com.torneariacentralshop.api.dtos.OrderResponseDTO;
import br.com.torneariacentralshop.api.entities.Order;
import br.com.torneariacentralshop.api.mappers.OrderMapper;
import br.com.torneariacentralshop.api.repository.OrderRepositoy;

@Service
public class OrderService {
	//Create, Read, Update, Delete
	@Autowired
	private OrderRepositoy orderRepositoy;
	
	public OrderResponseDTO creteOrder(OrderDTO orderDTO) {
		Order order = OrderMapper.toEntity(orderDTO);
		orderRepositoy.save(order);
		return OrderMapper.toDTO(order);		
	}
//	public List<OrderResponseDTO> ReadOrder()
//	
//
	}
