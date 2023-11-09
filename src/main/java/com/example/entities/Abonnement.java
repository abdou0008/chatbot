package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List; 

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Abonnement implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAbonnement;
    private String nomAbonnement;
    @OneToMany
    private List<Paiement> abonnementPaiement = new ArrayList<>();
}
