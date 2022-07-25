package com.application.ecommerce.web.controller;

import com.application.ecommerce.domain.Product;
import com.application.ecommerce.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> get() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return ResponseEntity.of(productService.getProduct(id));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int categoryId) {
        return ResponseEntity.of(productService.getByCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<Product> store(@RequestBody Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity destroy(@PathVariable int id) {
        return new ResponseEntity(productService.delete(id) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }
}
