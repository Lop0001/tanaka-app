package edu.cibertec.tanaka_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.tanaka_app.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameLike(String name);
	List<Product> findByState(Boolean state);
}
