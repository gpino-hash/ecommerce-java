package com.application.ecommerce.domain.service;

import com.application.ecommerce.domain.Product;
import com.application.ecommerce.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int id) {
        return productRepository.getProduct(id);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product create(Product product) {
        return productRepository.create(product);
    }

    public boolean delete(int id) {
        return getProduct(id).map(product -> {
            productRepository.getProduct(id);
            return true;
        }).orElse(false);
    }
}
