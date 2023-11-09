package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Abonnement;


public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
}
