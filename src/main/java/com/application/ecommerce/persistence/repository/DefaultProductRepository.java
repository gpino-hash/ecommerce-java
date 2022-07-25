package com.application.ecommerce.persistence.repository;

import com.application.ecommerce.domain.Product;
import com.application.ecommerce.domain.repository.ProductRepository;
import com.application.ecommerce.persistence.crud.ProductCrudRepository;
import com.application.ecommerce.persistence.entity.ProductEntity;
import com.application.ecommerce.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultProductRepository implements ProductRepository {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntities = (List<ProductEntity>) productCrudRepository.findAll();
        return mapper.toDomainProducts(productEntities);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductEntity> productEntities =  productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toDomainProducts(productEntities));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int amount) {
        Optional<List<ProductEntity>> optionalProducts = productCrudRepository.findByStockLessThanAndStatus(amount, true);
        return optionalProducts.map(products -> mapper.toDomainProducts(products));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toDomainProduct(product));
    }

    @Override
    public Product create(Product product) {
        ProductEntity productEntity = mapper.toProduct(product);
        return mapper.toDomainProduct(productCrudRepository.save(productEntity));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
