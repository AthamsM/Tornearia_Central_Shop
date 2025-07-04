package br.com.torneariacentralshop.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.torneariacentralshop.api.entities.Order;

@Repository
public interface OrderRepositoy extends JpaRepository<Order, Integer>{	
	@Query(value = ("SELECT * FROM orders WHERE user_id = :user_id"), nativeQuery = true)
	List<Order> findAllByUserId(@Param("user_id")int user_id);
}
