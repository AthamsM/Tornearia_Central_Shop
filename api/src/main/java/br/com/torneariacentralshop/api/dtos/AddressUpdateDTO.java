package br.com.torneariacentralshop.api.dtos;

public record AddressUpdateDTO(
		int id,
		String place, 
		String number, 
		String complement,
		String neighborhood, 
		String city, 
		String state,
		String cep
		) {}
