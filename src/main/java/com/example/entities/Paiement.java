package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Paiement implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPaiement;
    private String typePaiement;
}
