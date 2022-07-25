package com.application.ecommerce.persistence.mapper;

import com.application.ecommerce.domain.Product;
import com.application.ecommerce.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mapping(source = "categoryId", target = "category_id")
    @Mapping(source = "status", target = "active")
    Product toDomainProduct(ProductEntity productEntity);
    List<Product> toDomainProducts(List<ProductEntity> productEntities);

    @InheritInverseConfiguration
    @Mapping(target = "code", ignore = true)
    ProductEntity toProduct(Product product);
    List<ProductEntity> toProducts(List<Product> products);
}
