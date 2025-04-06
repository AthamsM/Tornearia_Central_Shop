package br.com.torneariacentralshop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.torneariacentralshop.api.entities.Address;
import br.com.torneariacentralshop.api.entities.User;

@Repository
public interface UserRepository extends JpaRepository< User, Integer> {
	@Modifying
	@Query(value = "INSERT INTO addresses(place, number, complement, neighborhood, city, state, cep, userId)"+
			"VALUES (:place, :number, :complement, :neighborhood, :city, :state, :cep, :userId)", nativeQuery = true)
	int saveAddresstoUser( String place, String number, String complement, String neighborhood, String city, String state,String cep, int userId  );
}
