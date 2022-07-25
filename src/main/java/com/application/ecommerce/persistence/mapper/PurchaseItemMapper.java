package com.application.ecommerce.persistence.mapper;

import com.application.ecommerce.domain.PurchaseItem;
import com.application.ecommerce.persistence.entity.ShoppingProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mapping(target = "quantity", source = "amount")
    @Mapping(source = "id.productId", target = "productId")
    @Mapping(source = "id.purchaseId", target = "purchaseId")
    @Mapping(source = "status", target = "active")
    PurchaseItem toPurchaseItem(ShoppingProductEntity shoppingProduct);

    @InheritInverseConfiguration
    @Mapping(target = "purchase", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "id.purchaseId", ignore = true)
    ShoppingProductEntity toShoppingProduct(PurchaseItem purchaseItem);
}
