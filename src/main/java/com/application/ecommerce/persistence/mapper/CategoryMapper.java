package com.application.ecommerce.persistence.mapper;

import com.application.ecommerce.domain.Category;
import com.application.ecommerce.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "description", target = "category")
    @Mapping(source = "status", target = "active")
    Category toDomainCategory(CategoryEntity categoryEntity);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryEntity toCategory(Category category);
}
