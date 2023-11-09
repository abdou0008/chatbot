package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {
}
