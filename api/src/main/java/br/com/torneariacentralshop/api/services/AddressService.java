package br.com.torneariacentralshop.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.dtos.AddressDTO;
import br.com.torneariacentralshop.api.dtos.AddressResponseDTO;
import br.com.torneariacentralshop.api.dtos.AddressUpdateDTO;
import br.com.torneariacentralshop.api.entities.Address;
import br.com.torneariacentralshop.api.entities.User;
import br.com.torneariacentralshop.api.mappers.AddressMapper;
import br.com.torneariacentralshop.api.repository.AddressRepository;
import br.com.torneariacentralshop.api.repository.UserRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private UserRepository userRepository;
	
	public AddressResponseDTO createAddressToUser(AddressDTO addressDTO) {
		User user = userRepository.findById(addressDTO.user()).orElseThrow(() -> new RuntimeException("Error search User"));
		Address address = AddressMapper.toEntity(addressDTO);
		address.setUser(user);
		return AddressMapper.toDTO(addressRepository.save(address));
	}
	
	public AddressResponseDTO updateAddressToUser(AddressUpdateDTO addressUpdateDTO) {
		Address address = addressRepository.findById(addressUpdateDTO.id()).orElseThrow(() -> new RuntimeException("Error search Address"));
		address.setPlace(addressUpdateDTO.place());
		address.setNumber(addressUpdateDTO.number());
		address.setComplement(addressUpdateDTO.complement());
		address.setNeighborhood(addressUpdateDTO.neighborhood());
		address.setCity(addressUpdateDTO.city());
		address.setState(addressUpdateDTO.state());
		address.setCep(addressUpdateDTO.cep());
		return AddressMapper.toDTO(addressRepository.save(address));
	}
	
	public boolean deleteAddress(int address_id) {
		Address address = addressRepository.findById(address_id).orElseThrow(() -> new RuntimeException("Error search Address"));
		addressRepository.delete(address);
		return true;
	}
	
	public List<AddressResponseDTO> readAddressToUser(int user_id) {
		return addressRepository.listAddresstoUser(user_id).stream().map(AddressMapper::toDTO).toList();	
	}
}
