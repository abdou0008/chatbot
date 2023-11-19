package com.example.chatbot.sec.services;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.sec.dao.UtilisateurRepositoriy;
import com.example.chatbot.sec.entities.Utilisateur;

import jakarta.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {
   
    @Autowired
    private UtilisateurRepositoriy utilisateurRepository;

    @Override
    public Utilisateur findById(Long userId) {
        return utilisateurRepository.findById(userId).orElse(null);
    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur updateUtilisateur(Long userId, Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = findById(userId);
        if (utilisateur != null) {
            utilisateur.setFirstname(utilisateurDetails.getFirstname());
            utilisateur.setLastname(utilisateurDetails.getLastname());
            utilisateur.setEmailUser(utilisateurDetails.getEmailUser());
            // Ajouter d'autres champs à mettre à jour si nécessaire

            return utilisateurRepository.save(utilisateur);
        }
        return null;
    }

    @Override
    public void deleteUtilisateur(Long userId) {
        utilisateurRepository.deleteById(userId);
    }
}
