package edu.cibertec.tanaka_app.services;

import java.util.List;
import java.util.Optional;

import edu.cibertec.tanaka_app.entities.Product;

public interface ProductService {

	List<Product> findAllOrFilterByName(String name);
	Optional<Product> findById(Long id);
	Product save(Product product, boolean state);
	Product update(Long id, Product product);
	void delete(Long id);
}
