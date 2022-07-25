package com.application.ecommerce.persistence.mapper;

import com.application.ecommerce.domain.Category;
import com.application.ecommerce.persistence.entity.CategoryEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T23:09:01-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toDomainCategory(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoryEntity.getId() != null ) {
            category.setId( categoryEntity.getId() );
        }
        category.setCategory( categoryEntity.getDescription() );
        if ( categoryEntity.getStatus() != null ) {
            category.setActive( categoryEntity.getStatus() );
        }

        return category;
    }

    @Override
    public CategoryEntity toCategory(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( category.getId() );
        categoryEntity.setDescription( category.getCategory() );
        categoryEntity.setStatus( category.isActive() );

        return categoryEntity;
    }
}
