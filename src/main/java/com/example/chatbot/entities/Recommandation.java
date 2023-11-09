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
public class Recommandation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRecommandation;
    private String nomRecommandation;
    
    @ManyToMany
    @JoinTable(
        name = "recommandation_utilisateur",
        joinColumns = @JoinColumn(name = "recommandation_id"),
        inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
    )
    private Set<Utilisateur> utilisateur = new HashSet<>();
}
