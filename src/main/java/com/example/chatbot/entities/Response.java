package com.example.chatbot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Response implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponse;
    private String nomResponse;

    @ManyToOne(fetch = FetchType.LAZY)
    private Message message;

    // @ManyToOne(fetch = FetchType.LAZY)
    // private Contact contact;

    @ManyToMany
    @JoinTable(
        name = "response_contact",
        joinColumns = @JoinColumn(name = "response_id"),
        inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    private Set<Contact> contacts = new HashSet<>();
}
