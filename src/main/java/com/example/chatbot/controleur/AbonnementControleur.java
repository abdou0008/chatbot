package com.example.chatbot.controleur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.chatbot.entities.Abonnement;
import com.example.chatbot.services.AbonnementService;

import java.util.List;


@RestController
@RequestMapping("/api/abonnements")
public class AbonnementControleur {

    @Autowired
    private AbonnementService abonnementService;

    @GetMapping("/{abonnementId}")
    public ResponseEntity<Abonnement> getAbonnementById(@PathVariable Long abonnementId) {
        Abonnement abonnement = abonnementService.findById(abonnementId);
        return ResponseEntity.ok().body(abonnement);
    }

    @GetMapping
    public ResponseEntity<List<Abonnement>> getAllAbonnements() {
        List<Abonnement> abonnements = abonnementService.findAll();
        return ResponseEntity.ok().body(abonnements);
    }

    @PostMapping
    public ResponseEntity<Abonnement> createAbonnement(@RequestBody Abonnement abonnement) {
        Abonnement createdAbonnement = abonnementService.saveAbonnement(abonnement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAbonnement);
    }

    @PutMapping("/{abonnementId}")
    public ResponseEntity<Abonnement> updateAbonnement(@PathVariable Long abonnementId, @RequestBody Abonnement abonnementDetails) {
        Abonnement updateAbonnement = abonnementService.updateAbonnement(abonnementId, abonnementDetails);
        if (updateAbonnement != null) {
            return ResponseEntity.ok().body(updateAbonnement);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{abonnementId}")
    public ResponseEntity<Void> deleteAbonnement(@PathVariable Long abonnementId) {
        abonnementService.deleteAbonnement(abonnementId);
        return ResponseEntity.noContent().build();
    }
}
