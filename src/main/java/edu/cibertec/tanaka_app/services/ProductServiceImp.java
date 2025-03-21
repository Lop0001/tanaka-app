package edu.cibertec.tanaka_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.tanaka_app.entities.Product;
import edu.cibertec.tanaka_app.repositories.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	
	private ProductRepository productRepository;
	
	//DI by constructor
	public ProductServiceImp(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<Product> findAllOrFilterByName(String name) {
		Optional<String> optionalName = Optional.ofNullable(name);
		if(optionalName.isPresent()) {
			return productRepository.findByNameLike("%"+name+"%");
		}
		return productRepository.findByState(true);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Product save(Product product, boolean state) {
		product.setState(true);
		return productRepository.save(product);
	}

	@Override
	public Product update(Long id, Product product) {
		Optional<Product> oProduct = productRepository.findById(id);
		if(oProduct.isPresent()) {
			Product productUpdate = oProduct.get();
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			productUpdate.setStock(product.getStock());
			productUpdate.setPrice(product.getPrice());
			productUpdate.setImage(product.getImage());
			
			return productRepository.save(productUpdate);

		}
		return productRepository.save(product);
	}



	@Override
	public void delete(Long id) {
		Product oProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        oProduct.setState(false);
        productRepository.save(oProduct);
	}

}
