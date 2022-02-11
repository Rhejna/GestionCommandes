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

public class Paiement implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Commande commande;
    private int montant;
    @Column(nullable = false)
    private String statut;

    public Long getId() {
        return id != null ? id : 0;
    }
}
