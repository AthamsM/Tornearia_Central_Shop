package br.com.torneariacentralshop.api.services;

import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.entities.Address;
import br.com.torneariacentralshop.api.entities.User;

@Service
public class AddressService {
	
	public Address saveAddress(Address address, User user) {
		address.setUser(user);
		return address;
		
	}
}
