package com.example.chatbot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Message implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMessage;
    private String nomMessage;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "message")
    private Set<Response> responses = new HashSet<>();
}
























