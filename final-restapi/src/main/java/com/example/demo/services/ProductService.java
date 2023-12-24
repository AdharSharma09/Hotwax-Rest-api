package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(String productId) {
		Optional<Product> findById = productRepository.findById(productId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	public Product createProduct(Product product) {
		// Perform any necessary business logic/validation before saving
		return productRepository.save(product);
	}

	public Product updateProduct(String productId, Product product) {
		// Validate if productId exists, then update the product
		Product existingProduct = getProductById(productId);
		existingProduct.setProductName(product.getProductName());
		existingProduct.setDescription(product.getDescription());
		// Update other fields as needed

		return productRepository.save(existingProduct);
	}

	public void deleteProduct(String productId) {
		// Validate if productId exists, then delete the product
		Product existingProduct = getProductById(productId);
		productRepository.delete(existingProduct);
	}
}
