package com.application.ecommerce.web.controller;

import com.application.ecommerce.domain.Product;
import com.application.ecommerce.domain.service.ProductService;
import io.swagger.annotations.*;
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
    @ApiOperation("Get all products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> get() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "search a product with ID", authorizations = {@Authorization(value = "jwt")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not fount"),
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "the id of de product", required = true, example = "7") @PathVariable int id) {
        return ResponseEntity.of(productService.getProduct(id));
    }

    @GetMapping("/category/{id}")
    @ApiOperation("search product by category id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not fount"),
    })
    public ResponseEntity<List<Product>> getByCategory(@ApiParam(value = "the id of de category", required = true, example = "1") @PathVariable("id") int categoryId) {
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
