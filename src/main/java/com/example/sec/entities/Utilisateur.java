package com.example.sec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;

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
    public Object getAppRoles() {
        return null;
    }
}
