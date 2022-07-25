package com.application.ecommerce.persistence.mapper;

import com.application.ecommerce.domain.Purchase;
import com.application.ecommerce.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mapping(source = "products", target = "items")
    @Mapping(source = "datePurchase", target = "date")
    Purchase toPurchase(PurchaseEntity purchase);
    List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntities);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    PurchaseEntity toPurchaseEntity(Purchase purchase);
}
