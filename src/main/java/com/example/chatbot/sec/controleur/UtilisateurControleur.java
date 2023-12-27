package com.example.chatbot.sec.controleur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.chatbot.sec.services.UtilisateurService;
import com.example.chatbot.sec.entities.Utilisateur;

import java.util.List;


@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurControleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/{userId}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long userId) {
        Utilisateur utilisateur = utilisateurService.findById(userId);
        return ResponseEntity.ok().body(utilisateur);
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.findAll();
        return ResponseEntity.ok().body(utilisateurs);
    }

    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur createdUtilisateur = utilisateurService.saveUtilisateur(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUtilisateur);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long userId, @RequestBody Utilisateur utilisateurDetails) {
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(userId, utilisateurDetails);
        if (updatedUtilisateur != null) {
            return ResponseEntity.ok().body(updatedUtilisateur);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long userId) {
        utilisateurService.deleteUtilisateur(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login/{emailU},{password}")
    public ResponseEntity<String> authenticateUser(@RequestBody Utilisateur utilisateur) {
        String emailUser = utilisateur.getEmailUser();
        String password = utilisateur.getPassword();

        // Vérification de l'authentification à l'aide du service d'utilisateur (c'est un exemple, vous devez implémenter votre logique d'authentification)
        boolean isAuthenticated = utilisateurService.authenticate(emailUser, password);
        if (isAuthenticated) {
            return ResponseEntity.ok().body("Utilisateur authentifié avec succès !");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nom d'utilisateur ou mot de passe incorrect !");
        }
    }
}
