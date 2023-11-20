package com.example.chatbot.controleur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.chatbot.entities.Recommandation;
import com.example.chatbot.services.RecommandationService;

import java.util.List;


@RestController
@RequestMapping("/api/recommandations")
public class RecommandationControleur {

    @Autowired
    private RecommandationService recommandationService;

    @GetMapping("/{recommandationId}")
    public ResponseEntity<Recommandation> getRecommandationById(@PathVariable Long recommandationId) {
        Recommandation recommandation = recommandationService.findById(recommandationId);
        return ResponseEntity.ok().body(recommandation);
    }

    @GetMapping
    public ResponseEntity<List<Recommandation>> getAllRecommandations() {
        List<Recommandation> recommandations = recommandationService.findAll();
        return ResponseEntity.ok().body(recommandations);
    }

    @PostMapping
    public ResponseEntity<Recommandation> createRecommandation(@RequestBody Recommandation recommandation) {
        Recommandation createdRecommandation = recommandationService.saveRecommandation(recommandation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecommandation);
    }

    @PutMapping("/{recommandationId}")
    public ResponseEntity<Recommandation> updateRecommandation(@PathVariable Long recommandationId, @RequestBody Recommandation recommandationDetails) {
        Recommandation updateRecommandation = recommandationService.updateRecommandation(recommandationId, recommandationDetails);
        if (updateRecommandation != null) {
            return ResponseEntity.ok().body(updateRecommandation);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{recommandationId}")
    public ResponseEntity<Void> deleteRecommandation(@PathVariable Long recommandationId) {
        recommandationService.deleteRecommandation(recommandationId);
        return ResponseEntity.noContent().build();
    }
}
