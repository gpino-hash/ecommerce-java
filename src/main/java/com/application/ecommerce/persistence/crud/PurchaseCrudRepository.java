package com.application.ecommerce.persistence.crud;

import com.application.ecommerce.persistence.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {

    Optional<List<PurchaseEntity>> findByIdClient(String clientId);
}
