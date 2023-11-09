package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Recommandation;

public interface RecommandationRepository extends JpaRepository<Recommandation,Long> {
    
}
