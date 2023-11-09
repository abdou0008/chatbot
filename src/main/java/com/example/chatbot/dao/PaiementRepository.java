package com.example.chatbot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot.entities.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {
}
