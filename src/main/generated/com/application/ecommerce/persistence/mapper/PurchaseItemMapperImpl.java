package com.application.ecommerce.persistence.mapper;

import com.application.ecommerce.domain.PurchaseItem;
import com.application.ecommerce.persistence.entity.ShoppingProductEntity;
import com.application.ecommerce.persistence.entity.ShoppingProductPK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-25T13:19:06-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
@Component
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

    @Override
    public PurchaseItem toPurchaseItem(ShoppingProductEntity shoppingProduct) {
        if ( shoppingProduct == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        if ( shoppingProduct.getAmount() != null ) {
            purchaseItem.setQuantity( shoppingProduct.getAmount() );
        }
        Integer productId = shoppingProductIdProductId( shoppingProduct );
        if ( productId != null ) {
            purchaseItem.setProductId( productId );
        }
        Integer purchaseId = shoppingProductIdPurchaseId( shoppingProduct );
        if ( purchaseId != null ) {
            purchaseItem.setPurchaseId( purchaseId );
        }
        if ( shoppingProduct.getStatus() != null ) {
            purchaseItem.setActive( shoppingProduct.getStatus() );
        }
        purchaseItem.setTotal( shoppingProduct.getTotal() );

        return purchaseItem;
    }

    @Override
    public ShoppingProductEntity toShoppingProduct(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        ShoppingProductEntity shoppingProductEntity = new ShoppingProductEntity();

        shoppingProductEntity.setId( purchaseItemToShoppingProductPK( purchaseItem ) );
        shoppingProductEntity.setAmount( purchaseItem.getQuantity() );
        shoppingProductEntity.setStatus( purchaseItem.isActive() );
        shoppingProductEntity.setTotal( purchaseItem.getTotal() );

        return shoppingProductEntity;
    }

    private Integer shoppingProductIdProductId(ShoppingProductEntity shoppingProductEntity) {
        if ( shoppingProductEntity == null ) {
            return null;
        }
        ShoppingProductPK id = shoppingProductEntity.getId();
        if ( id == null ) {
            return null;
        }
        Integer productId = id.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    private Integer shoppingProductIdPurchaseId(ShoppingProductEntity shoppingProductEntity) {
        if ( shoppingProductEntity == null ) {
            return null;
        }
        ShoppingProductPK id = shoppingProductEntity.getId();
        if ( id == null ) {
            return null;
        }
        Integer purchaseId = id.getPurchaseId();
        if ( purchaseId == null ) {
            return null;
        }
        return purchaseId;
    }

    protected ShoppingProductPK purchaseItemToShoppingProductPK(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        ShoppingProductPK shoppingProductPK = new ShoppingProductPK();

        shoppingProductPK.setProductId( purchaseItem.getProductId() );

        return shoppingProductPK;
    }
}
