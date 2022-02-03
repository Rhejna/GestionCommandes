package com.example.demo.classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table
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

    public Contenu() {
    }

    public Contenu(int qte, Article article, Commande commande, double prix_total) {
        this.qte = qte;
        this.article = article;
        this.commande = commande;
        this.prix_total = prix_total;
    }

    //    GETTER & SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(double prix_total) {
        this.prix_total = prix_total;
    }
}
