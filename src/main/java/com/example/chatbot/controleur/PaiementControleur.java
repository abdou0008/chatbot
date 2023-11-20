package com.example.chatbot.controleur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.chatbot.entities.Paiement;
import com.example.chatbot.services.PaiementService;

import java.util.List;


@RestController
@RequestMapping("/api/paiements")
public class PaiementControleur {

    @Autowired
    private PaiementService paiementService;

    @GetMapping("/{paiementId}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long paiementId) {
        Paiement paiement = paiementService.findById(paiementId);
        return ResponseEntity.ok().body(paiement);
    }

    @GetMapping
    public ResponseEntity<List<Paiement>> getAllPaiments() {
        List<Paiement> paiements = paiementService.findAll();
        return ResponseEntity.ok().body(paiements);
    }

    @PostMapping
    public ResponseEntity<Paiement> createPaiement(@RequestBody Paiement paiement) {
        Paiement createdPaiement = paiementService.savePaiement(paiement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPaiement);
    }

    @PutMapping("/{paiementId}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable Long paiementId, @RequestBody Paiement paiementDetails) {
        Paiement updatePaiement = paiementService.updatePaiement(paiementId, paiementDetails);
        if (updatePaiement != null) {
            return ResponseEntity.ok().body(updatePaiement);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{paiementId}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long paiementId) {
        paiementService.deletePaiement(paiementId);
        return ResponseEntity.noContent().build();
    }
}
