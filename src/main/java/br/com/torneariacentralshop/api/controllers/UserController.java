package br.com.torneariacentralshop.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.torneariacentralshop.api.dtos.UserAndAddressResponseDTO;
import br.com.torneariacentralshop.api.dtos.UserDTO;
import br.com.torneariacentralshop.api.dtos.UserResponseDTO;
import br.com.torneariacentralshop.api.dtos.UserUpdatedDTO;
import br.com.torneariacentralshop.api.entities.Address;
import br.com.torneariacentralshop.api.services.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserAndAddressResponseDTO> createProduct(@RequestBody UserDTO userDTO) {
		return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserUpdatedDTO userUpdatedDTO){
		return new ResponseEntity<>(userService.updateUser(userUpdatedDTO), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> readUser(@PathVariable(name = "id")int id){
		return new ResponseEntity<>(userService.readUser(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> readUserAll(){
		return new ResponseEntity<>(userService.readUserAll(), HttpStatus.OK);
	}
	

}
