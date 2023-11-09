package com.example.chatbot.sec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot.sec.entities.Utilisateur;


public interface UtilisateurRepositoriy extends JpaRepository<Utilisateur,Long> {

}
