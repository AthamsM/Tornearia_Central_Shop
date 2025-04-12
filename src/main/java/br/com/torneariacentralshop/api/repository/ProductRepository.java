package br.com.torneariacentralshop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.torneariacentralshop.api.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query(value = ("INSERT INTO image_products (url, product_id) VALUES (:url, :product_id)"), nativeQuery = true)
	void saveImage(@Param("url")String url, @Param("product_id")int product_id);
}
