package br.com.torneariacentralshop.api.dtos;

import java.math.BigDecimal;

public record ProductUpdateDTO(
		int id, 
		String name, 
		String description, 
		BigDecimal price, 
		float rating, 
		int stock
		) {}
