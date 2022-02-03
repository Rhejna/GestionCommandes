package com.example.demo.classes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
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

    public Paiement() {
    }

    public Paiement(Long id, Commande commande, int montant, String statut) {
        this.id = id;
        this.commande = commande;
        this.montant = montant;
        this.statut = statut;
    }

    public Paiement(Commande commande, int montant, String statut) {
        this.commande = commande;
        this.montant = montant;
        this.statut = statut;
    }

    //    GETTER & SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
