package br.com.torneariacentralshop.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.dtos.UserAndAddressResponseDTO;
import br.com.torneariacentralshop.api.dtos.UserDTO;
import br.com.torneariacentralshop.api.dtos.UserResponseDTO;
import br.com.torneariacentralshop.api.dtos.UserUpdatedDTO;
import br.com.torneariacentralshop.api.entities.Address;
import br.com.torneariacentralshop.api.entities.User;
import br.com.torneariacentralshop.api.mappers.AddressMapper;
import br.com.torneariacentralshop.api.mappers.UserMapper;
import br.com.torneariacentralshop.api.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressService addressService;

	@Transactional
	public UserAndAddressResponseDTO createUser(UserDTO userDTO) {
		Address address = new Address();
		address = AddressMapper.toEntity(userDTO.address());
		System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP"+address.getCity());
		User user = UserMapper.toEntinty(userDTO);
		userRepository.save(user);
		addressService.saveAddress(address, user);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		userRepository.saveAddresstoUser(address.getPlace(), address.getNumber(), address.getComplement(), address.getNeighborhood(), address.getCity(), address.getState(), address.getCep(), user.getId());
		return UserMapper.UserAndAddressToDTO(user, AddressMapper.toDTO(address));
	}

	public UserResponseDTO updateUser(UserUpdatedDTO userUpdatedDTO) {
		User user = userRepository.findById(userUpdatedDTO.id())
				.orElseThrow(() -> new RuntimeException("Error finding user to do update"));
		user.setName(userUpdatedDTO.name());
		user.setEmail(userUpdatedDTO.email());
		user.setPassword(userUpdatedDTO.password());
		userRepository.save(user);
		return UserMapper.toDTO(user);

	}

	public boolean deleteUser(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("error finding user to do delete"));
		userRepository.delete(user);
		return true;
	}

	public UserResponseDTO readUser(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("error finding user to do read"));
		return UserMapper.toDTO(user);
	}

	public List<UserResponseDTO> readUserAll() {
		return userRepository.findAll().stream().map(UserMapper::toDTO).toList();
	}

}
