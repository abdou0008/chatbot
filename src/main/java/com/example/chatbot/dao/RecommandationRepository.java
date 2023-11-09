package com.example.chatbot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot.entities.Recommandation;

public interface RecommandationRepository extends JpaRepository<Recommandation,Long> {
    
}
