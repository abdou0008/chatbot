package com.example.chatbot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;

import com.example.chatbot.sec.entities.Utilisateur;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Conversation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idConversation;
    private String nomConvesation;

    @ManyToOne(fetch = FetchType.LAZY)
    private Utilisateur utilisateur;
}
