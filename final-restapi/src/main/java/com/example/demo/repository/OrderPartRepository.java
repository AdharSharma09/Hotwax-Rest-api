package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.OrderPart;
import com.example.demo.entities.Party;

public interface OrderPartRepository extends JpaRepository<OrderPart, String> {


}
