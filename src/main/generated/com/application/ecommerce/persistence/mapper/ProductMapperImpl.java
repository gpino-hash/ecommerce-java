package com.application.ecommerce.persistence.mapper;

import com.application.ecommerce.domain.Product;
import com.application.ecommerce.persistence.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-25T14:31:49-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Product toDomainProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        if ( productEntity.getCategoryId() != null ) {
            product.setCategoryId( productEntity.getCategoryId() );
        }
        if ( productEntity.getStatus() != null ) {
            product.setActive( productEntity.getStatus() );
        }
        if ( productEntity.getId() != null ) {
            product.setId( productEntity.getId() );
        }
        product.setName( productEntity.getName() );
        product.setPrice( productEntity.getPrice() );
        if ( productEntity.getStock() != null ) {
            product.setStock( productEntity.getStock() );
        }
        product.setCategory( categoryMapper.toDomainCategory( productEntity.getCategory() ) );

        return product;
    }

    @Override
    public List<Product> toDomainProducts(List<ProductEntity> productEntities) {
        if ( productEntities == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productEntities.size() );
        for ( ProductEntity productEntity : productEntities ) {
            list.add( toDomainProduct( productEntity ) );
        }

        return list;
    }

    @Override
    public ProductEntity toProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setCategoryId( product.getCategoryId() );
        productEntity.setStatus( product.isActive() );
        productEntity.setId( product.getId() );
        productEntity.setName( product.getName() );
        productEntity.setPrice( product.getPrice() );
        productEntity.setStock( product.getStock() );
        productEntity.setCategory( categoryMapper.toCategory( product.getCategory() ) );

        return productEntity;
    }

    @Override
    public List<ProductEntity> toProducts(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductEntity> list = new ArrayList<ProductEntity>( products.size() );
        for ( Product product : products ) {
            list.add( toProduct( product ) );
        }

        return list;
    }
}
