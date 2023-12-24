package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.OrderItem;
import com.example.demo.entities.OrderItemId;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {

}
