package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.AddressDTO;
import br.com.torneariacentralshop.api.dtos.AddressResponseDTO;
import br.com.torneariacentralshop.api.entities.Address;

public class AddressMapper {
	
	public static AddressResponseDTO toDTO(Address address) {
		return new AddressResponseDTO(address.getId(),address.getUser().getId(),address.getPlace(), address.getNumber(), address.getComplement(), address.getNeighborhood(), address.getCity(), address.getState(), address.getCep());
	}
	
	public static Address toEntity(AddressDTO addressDTO) {
		Address address = new Address();
		address.setPlace(addressDTO.place());
		address.setNumber(addressDTO.number());
		address.setComplement(addressDTO.complement());
		address.setNeighborhood(addressDTO.neighborhood());
		address.setCity(addressDTO.city());
		address.setState(addressDTO.state());
		address.setCep(addressDTO.cep());
		return address;
	}
}
