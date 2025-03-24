package edu.cibertec.tanaka_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cibertec.tanaka_app.entities.Product;
import edu.cibertec.tanaka_app.services.ProductService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@GetMapping("/")
	public String findAllOrFilterByName(@RequestParam(required=false) String name,  Model model){
		List<Product> products = productService.findAllOrFilterByName(name);
		model.addAttribute("datos", products);
		return "productos";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable Long id, Model model) {
		
		Optional<Product> oProduct = productService.findById(id);
		System.out.println("mi objeto::::::" + oProduct);
		model.addAttribute("producto",oProduct.get());
		return "detalle-producto";
	}
}
