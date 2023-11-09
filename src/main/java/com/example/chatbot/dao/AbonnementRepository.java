package com.example.chatbot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot.entities.Abonnement;


public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
}
