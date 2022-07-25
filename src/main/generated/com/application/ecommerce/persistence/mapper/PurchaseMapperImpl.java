package com.application.ecommerce.persistence.mapper;

import com.application.ecommerce.domain.Purchase;
import com.application.ecommerce.domain.PurchaseItem;
import com.application.ecommerce.persistence.entity.PurchaseEntity;
import com.application.ecommerce.persistence.entity.ShoppingProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-25T13:36:35-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Autowired
    private PurchaseItemMapper purchaseItemMapper;

    @Override
    public Purchase toPurchase(PurchaseEntity purchase) {
        if ( purchase == null ) {
            return null;
        }

        Purchase purchase1 = new Purchase();

        purchase1.setItems( shoppingProductEntityListToPurchaseItemList( purchase.getProducts() ) );
        purchase1.setDate( purchase.getDatePurchase() );
        if ( purchase.getId() != null ) {
            purchase1.setId( purchase.getId() );
        }
        purchase1.setClientId( purchase.getClientId() );
        purchase1.setPaymentMethod( purchase.getPaymentMethod() );
        purchase1.setComment( purchase.getComment() );
        purchase1.setStatus( purchase.getStatus() );

        return purchase1;
    }

    @Override
    public List<Purchase> toPurchases(List<PurchaseEntity> purchaseEntities) {
        if ( purchaseEntities == null ) {
            return null;
        }

        List<Purchase> list = new ArrayList<Purchase>( purchaseEntities.size() );
        for ( PurchaseEntity purchaseEntity : purchaseEntities ) {
            list.add( toPurchase( purchaseEntity ) );
        }

        return list;
    }

    @Override
    public PurchaseEntity toPurchaseEntity(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        PurchaseEntity purchaseEntity = new PurchaseEntity();

        purchaseEntity.setProducts( purchaseItemListToShoppingProductEntityList( purchase.getItems() ) );
        purchaseEntity.setDatePurchase( purchase.getDate() );
        purchaseEntity.setId( purchase.getId() );
        purchaseEntity.setClientId( purchase.getClientId() );
        purchaseEntity.setPaymentMethod( purchase.getPaymentMethod() );
        purchaseEntity.setComment( purchase.getComment() );
        purchaseEntity.setStatus( purchase.getStatus() );

        return purchaseEntity;
    }

    protected List<PurchaseItem> shoppingProductEntityListToPurchaseItemList(List<ShoppingProductEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItem> list1 = new ArrayList<PurchaseItem>( list.size() );
        for ( ShoppingProductEntity shoppingProductEntity : list ) {
            list1.add( purchaseItemMapper.toPurchaseItem( shoppingProductEntity ) );
        }

        return list1;
    }

    protected List<ShoppingProductEntity> purchaseItemListToShoppingProductEntityList(List<PurchaseItem> list) {
        if ( list == null ) {
            return null;
        }

        List<ShoppingProductEntity> list1 = new ArrayList<ShoppingProductEntity>( list.size() );
        for ( PurchaseItem purchaseItem : list ) {
            list1.add( purchaseItemMapper.toShoppingProduct( purchaseItem ) );
        }

        return list1;
    }
}
