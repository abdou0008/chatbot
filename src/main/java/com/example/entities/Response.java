package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Response implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponse;
    private String nomResponse;

    @ManyToMany
    @JoinTable(
        name = "response_contact",
        joinColumns = @JoinColumn(name = "response_id"),
        inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    private Set<Contact> contacts = new HashSet<>();
}
