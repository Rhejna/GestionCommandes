package com.example.demo.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data //crée des getters et setters
@NoArgsConstructor // cree un constructeur par defaut
@AllArgsConstructor

public class Client implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String password;
    private int numero;
    @Column(nullable = false)
    private String statut;

    public Long getId() {
        return id != null ? id : 0;
    }

}
