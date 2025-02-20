package com.zeuss.orderservice.service;

import com.zeuss.orderservice.client.InventoryClient;
import com.zeuss.orderservice.dto.OrderRequest;
import com.zeuss.orderservice.model.Order;
import com.zeuss.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest){
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
        }else {
            throw new RuntimeException("Product with skuCode" + orderRequest.skuCode() + " is not in stock");
        }
    }
}
