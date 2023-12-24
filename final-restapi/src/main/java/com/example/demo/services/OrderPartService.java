package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.OrderPart;
import com.example.demo.repository.OrderPartRepository;

@Service
public class OrderPartService {

    private final OrderPartRepository orderPartRepository;

    @Autowired
    public OrderPartService(OrderPartRepository orderPartRepository) {
        this.orderPartRepository = orderPartRepository;
    }

    public Optional<OrderPart> getOrderPartById(String orderId, String orderPartSeqId) {
		return orderPartRepository.findById(orderId);
    }	

    public List<OrderPart> getAllOrderParts() {
        return orderPartRepository.findAll();
    }

    public OrderPart createOrderPart(OrderPart orderPart) {
        // Add any business logic/validation before saving to the database
        return orderPartRepository.save(orderPart);
    }

    @Transactional
    public OrderPart updateOrderPart(String orderId, String orderPartSeqId, OrderPart updatedOrderPart) {
        Optional<OrderPart> existingOrderPart = getOrderPartById(orderId, orderPartSeqId);

        if (existingOrderPart.isPresent()) {
            // Update existing orderPart with new data
            OrderPart orderPartToUpdate = existingOrderPart.get();
            orderPartToUpdate.setPartName(updatedOrderPart.getPartName());
            orderPartToUpdate.setStatusId(updatedOrderPart.getStatusId());
            // Update other fields as needed

            // Save the updated orderPart
            return orderPartRepository.save(orderPartToUpdate);
        } else {
            // Handle case where orderPart is not found
//            throw new Exception("OrderPart not found with id " + orderId + "-" + orderPartSeqId);
        	return null;
        }
    }

    public void deleteOrderPart(String orderId, String orderPartSeqId) {
        orderPartRepository.deleteById(orderId);
    }
}
