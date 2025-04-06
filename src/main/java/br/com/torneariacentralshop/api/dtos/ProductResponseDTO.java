package br.com.torneariacentralshop.api.dtos;

import java.math.BigDecimal;

public record ProductResponseDTO(int id, String name, String description, BigDecimal price, float rating, int stock) {}
