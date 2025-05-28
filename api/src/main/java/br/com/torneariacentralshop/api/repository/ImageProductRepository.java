package br.com.torneariacentralshop.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.torneariacentralshop.api.entities.ImageProduct;

@Repository
public interface ImageProductRepository extends JpaRepository<ImageProduct, Integer>{
	@Query(value = "SELECT * FROM image_products WHERE product_id = :product_id)", nativeQuery = true)
	List<ImageProduct> listImagetoProduct(@Param("product_id")int product_id);
}
