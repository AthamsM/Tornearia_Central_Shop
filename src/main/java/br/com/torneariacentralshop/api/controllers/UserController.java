package br.com.torneariacentralshop.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.torneariacentralshop.api.dtos.AddressDTO;
import br.com.torneariacentralshop.api.dtos.AddressResponseDTO;
import br.com.torneariacentralshop.api.dtos.AddressUpdateDTO;
import br.com.torneariacentralshop.api.dtos.UserDTO;
import br.com.torneariacentralshop.api.dtos.UserResponseDTO;
import br.com.torneariacentralshop.api.dtos.UserUpdatedDTO;
import br.com.torneariacentralshop.api.services.AddressService;
import br.com.torneariacentralshop.api.services.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired 
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> createProduct(@RequestBody UserDTO userDTO) {
		return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
	}
	
	@PostMapping("/address")
	public ResponseEntity<AddressResponseDTO> createAddressToUser(@RequestBody AddressDTO addressDTO){
		return new ResponseEntity<>(addressService.createAddressToUser(addressDTO), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserUpdatedDTO userUpdatedDTO){
		return new ResponseEntity<>(userService.updateUser(userUpdatedDTO), HttpStatus.OK);
	}
	
	@PutMapping("/address")
	public ResponseEntity<AddressResponseDTO> updateAddressToUser(@RequestBody AddressUpdateDTO addressUpdateDTO){
		return new ResponseEntity<>(addressService.updateAddressToUser(addressUpdateDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> readUser(@PathVariable(name = "id")int id){
		return new ResponseEntity<>(userService.readUser(id), HttpStatus.OK);
	}
	
	@GetMapping("/address/{user_id}")
	public ResponseEntity<List<AddressResponseDTO>> readAddressToUser(@PathVariable(name = "user_id")int user_id){
		return new ResponseEntity<>(addressService.readAddressToUser(user_id), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable(name = "id")int id){
		return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
	}
	
	@DeleteMapping("address/{id}")
	public ResponseEntity<Boolean> deleteAddressToUser(@PathVariable(name = "id")int id){
		return new ResponseEntity<>(addressService.deleteAddress(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> readUserAll(){
		return new ResponseEntity<>(userService.readUserAll(), HttpStatus.OK);
	}
}
