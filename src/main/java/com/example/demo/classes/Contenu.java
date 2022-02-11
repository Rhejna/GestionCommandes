package com.example.demo.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table
@Data //crée des getters et setters
@NoArgsConstructor // cree un constructeur par defaut
@AllArgsConstructor

public class Contenu implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private int qte;
    @ManyToOne(fetch = FetchType.EAGER)
    private Article article;
    @ManyToOne(fetch = FetchType.EAGER)
    private Commande commande;
    private double prix_total;

    public Long getId() {
        return id != null ? id : 0;
    }

}
