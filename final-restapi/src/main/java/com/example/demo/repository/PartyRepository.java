package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Party;

public interface PartyRepository extends JpaRepository<Party, String>{

}
