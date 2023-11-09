package com.example.chatbot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;

import com.example.chatbot.sec.entities.Utilisateur;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Abonnement implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAbonnement;
    private String nomAbonnement;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "abonnement")
    private Set<Paiement> paiements = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Utilisateur utilisateur;
}
