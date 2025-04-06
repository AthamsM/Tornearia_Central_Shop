package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.AddressDTO;
import br.com.torneariacentralshop.api.entities.Address;

public class AddressMapper {
	
	public static AddressDTO toDTO(Address address) {
		return new AddressDTO(address.getPlace(), address.getNumber(), address.getComplement(), address.getNeighborhood(), address.getCity(), address.getState(), address.getCep());
	}
	
	public static Address toEntity(AddressDTO addressDTO) {
		System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"+ addressDTO);
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
