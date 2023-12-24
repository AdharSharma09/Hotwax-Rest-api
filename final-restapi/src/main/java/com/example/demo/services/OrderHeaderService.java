package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.OrderHeader;
import com.example.demo.repository.OrderHeaderRepository;

@Service
public class OrderHeaderService {

	@Autowired
    private OrderHeaderRepository orderHeaderRepository;

    public List<OrderHeader> getAllOrders() {
        return orderHeaderRepository.findAll();
    }

    public Optional<OrderHeader> getOrderById(String orderId) {
        return orderHeaderRepository.findById(orderId);
    }

    public OrderHeader createOrder(OrderHeader orderHeader) {
        // Add any additional business logic/validation here
        return orderHeaderRepository.save(orderHeader);
    }

    public OrderHeader updateOrderName(String orderId, String newOrderName) {
        Optional<OrderHeader> optionalOrderHeader = orderHeaderRepository.findById(orderId);

        if (optionalOrderHeader.isPresent()) {
            OrderHeader orderHeader = optionalOrderHeader.get();
            orderHeader.setOrderName(newOrderName);
            return orderHeaderRepository.save(orderHeader);
        }

        // Handle case where the order with the given ID is not found
        return null;
    }
}
