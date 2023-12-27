package com.example.chatbot.sec.services;

import java.util.List;


import com.example.chatbot.sec.entities.Utilisateur;

public interface UtilisateurService {
    Utilisateur findById(Long userId);
    List<Utilisateur> findAll();
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    Utilisateur updateUtilisateur(Long userId, Utilisateur utilisateurDetails);
    void deleteUtilisateur(Long userId);
    boolean authenticate(String emailUser, String password);
}
