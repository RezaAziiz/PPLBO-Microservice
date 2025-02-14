package com.zeuss.orderservice.repository;

import com.zeuss.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Long>{

}
