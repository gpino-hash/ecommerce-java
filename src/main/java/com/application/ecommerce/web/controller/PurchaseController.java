package com.application.ecommerce.web.controller;

import com.application.ecommerce.domain.Purchase;
import com.application.ecommerce.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("id") String clientId) {
        return ResponseEntity.of(service.getByClient(clientId));
    }

    @PostMapping
    public ResponseEntity<Purchase> store(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(service.create(purchase), HttpStatus.CREATED);
    }
}
