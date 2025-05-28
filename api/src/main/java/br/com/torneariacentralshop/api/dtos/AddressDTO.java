package br.com.torneariacentralshop.api.dtos;

public record AddressDTO(
		int user,
		String place, 
		String number, 
		String complement,
		String neighborhood, 
		String city, 
		String state,
		String cep
		) {}
