package com.example.chatbot.sec.services;

import lombok.AllArgsConstructor;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.sec.dao.UtilisateurRepository;
import com.example.chatbot.sec.entities.Utilisateur;

import jakarta.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {
   
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    //private Map<String, String> utilisateurs = new HashMap<>();

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

    public boolean authenticate(String emailUser, String password) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByEmailUser(emailUser);
        if (utilisateurOptional.isPresent()) {
            Utilisateur utilisateur = utilisateurOptional.get();
            // Récupérer le mot de passe stocké pour cet utilisateur
            String storedPassword = utilisateur.getPassword();
            // Vérifier si le mot de passe correspond
            return password.equals(storedPassword);
        }
        return false; // L'utilisateur n'existe pas dans la base de données
    }
    
}
