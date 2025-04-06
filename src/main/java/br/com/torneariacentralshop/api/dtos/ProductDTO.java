package br.com.torneariacentralshop.api.dtos;

import java.math.BigDecimal;

public record ProductDTO(String name, String description, BigDecimal price, int stock) {}
