package br.com.torneariacentralshop.api.dtos;

public record AddressResponseDTO(
		int id,
		int user_id,
		String place, 
		String number, 
		String complement,
		String neighborhood, 
		String city, 
		String state,
		String cep
        ) {}
