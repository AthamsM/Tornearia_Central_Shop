package br.com.torneariacentralshop.api.dtos;

public record UserUpdatedDTO(
		int id, 
		String name, 
		String email, 
		String password
		) {}
