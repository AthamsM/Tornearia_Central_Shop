package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.AddressDTO;
import br.com.torneariacentralshop.api.dtos.UserAndAddressResponseDTO;
import br.com.torneariacentralshop.api.dtos.UserDTO;
import br.com.torneariacentralshop.api.dtos.UserResponseDTO;
import br.com.torneariacentralshop.api.entities.Address;
import br.com.torneariacentralshop.api.entities.User;

public class UserMapper {
	public static UserAndAddressResponseDTO UserAndAddressToDTO(User user, AddressDTO addressDTO){
		return new UserAndAddressResponseDTO(user.getName(), user.getEmail(), addressDTO);		
	}
	public static UserResponseDTO toDTO(User user){
		return new UserResponseDTO(user.getName(), user.getEmail());		
	}
	public static User toEntinty(UserDTO userDTO) {
		
		User user = new User();
		user.setName(userDTO.name());
		user.setEmail(userDTO.email());
		user.setPassword(userDTO.password());
		return user;
	}
}
