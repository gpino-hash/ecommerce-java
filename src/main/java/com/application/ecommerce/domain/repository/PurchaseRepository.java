package com.application.ecommerce.domain.repository;

import com.application.ecommerce.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();

    Optional<List<Purchase>> getByClient(String clientId);

    Purchase create(Purchase purchase);
}
