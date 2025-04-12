package br.com.torneariacentralshop.api.mappers;

import br.com.torneariacentralshop.api.dtos.UserDTO;
import br.com.torneariacentralshop.api.dtos.UserResponseDTO;
import br.com.torneariacentralshop.api.entities.User;

public class UserMapper {
	public static UserResponseDTO toDTO(User user){
		return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());		
	}
	
	public static User toEntinty(UserDTO userDTO) {
		
		User user = new User();
		user.setName(userDTO.name());
		user.setEmail(userDTO.email());
		user.setPassword(userDTO.password());
		return user;
	}
}
