package com.application.ecommerce.persistence.repository;

import com.application.ecommerce.domain.Purchase;
import com.application.ecommerce.domain.repository.PurchaseRepository;
import com.application.ecommerce.persistence.crud.PurchaseCrudRepository;
import com.application.ecommerce.persistence.entity.PurchaseEntity;
import com.application.ecommerce.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultPurchaseRepository implements PurchaseRepository {

    @Autowired
    private PurchaseCrudRepository repository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<PurchaseEntity>) repository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return repository.findByIdClient(clientId)
                .map(purchaseEntities -> mapper.toPurchases(purchaseEntities));
    }

    @Override
    public Purchase create(Purchase purchase) {
        PurchaseEntity entity = mapper.toPurchaseEntity(purchase);
        entity.getProducts().forEach(shoppingProduct -> shoppingProduct.setPurchase(entity));
        return mapper.toPurchase(repository.save(entity));
    }
}
