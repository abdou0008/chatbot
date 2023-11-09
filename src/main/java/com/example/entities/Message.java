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
public class Message implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMessage;
    private String nomMessage;
    @OneToMany
    private List<Response> messageConversation = new ArrayList<>();
}
























