package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.OrderHeader;

@Repository
public interface OrderHeaderRepository extends JpaRepository<OrderHeader, String> {

}
