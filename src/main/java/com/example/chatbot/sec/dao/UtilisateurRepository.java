package com.example.chatbot.sec.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot.sec.entities.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmailUser(String emailUser);
}
