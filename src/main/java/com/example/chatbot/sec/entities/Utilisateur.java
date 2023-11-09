package com.example.chatbot.sec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;

import com.example.chatbot.entities.Abonnement;
import com.example.chatbot.entities.Conversation;
import com.example.chatbot.entities.Paiement;
import com.example.chatbot.entities.Recommandation;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String codeUtilisateur;
    private String firstname;
    private String lastname;
    private String password;
    private String emailUser;
    private String phone;
    private String adressUser;
    private int age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
    private Set<Abonnement> abonnement = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
    private Set<Paiement> paiements = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
    private Set<Conversation> conversations = new HashSet<>();

    @ManyToMany(mappedBy = "utilisateur")
    private Set<Recommandation> recommandations = new HashSet<>();
}
