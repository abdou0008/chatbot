package com.example.chatbot.entities;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContact;
    private String nomContact;
    private String emailContact;
    private String telephoneContact;
    private String adresseContact;

    @ManyToMany(mappedBy = "contacts")
    private Set<Response> responses = new HashSet<>();

}
