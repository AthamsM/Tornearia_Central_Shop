package br.com.torneariacentralshop.api.dtos;

import br.com.torneariacentralshop.api.entities.Address;

public record UserAndAddressResponseDTO(String name, String email, AddressDTO addressDTO) {

}
