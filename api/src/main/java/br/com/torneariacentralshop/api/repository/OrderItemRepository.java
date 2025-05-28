package br.com.torneariacentralshop.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.torneariacentralshop.api.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	@Query(value = ("SELECT * FROM order_items WHERE order_id = :order_id"), nativeQuery = true)
	List<OrderItem> findAllByOrderId(@Param("order_id")int order_id);
}
