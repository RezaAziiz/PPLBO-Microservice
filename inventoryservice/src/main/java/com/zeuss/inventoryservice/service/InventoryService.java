package com.zeuss.inventoryservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.zeuss.inventoryservice.repository.InventoryRepository;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity){
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);

    }
}
