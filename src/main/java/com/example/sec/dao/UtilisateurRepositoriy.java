package com.example.sec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sec.entities.Utilisateur;


public interface UtilisateurRepositoriy extends JpaRepository<Utilisateur,Long> {

    Utilisateur findByUsername(String username);

}
