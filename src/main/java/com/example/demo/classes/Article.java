package com.example.demo.classes;

import javax.persistence.*;
import java.io.Serializable;

@Entity //for hibernate
@Table
public class Article implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(nullable = false)
    private String reference;
    @Column(nullable = false)
    private String designation;
    private double prix;

    public Article() {
    }

    public Article(Long id, String reference, String designation, double prix) {
        this.id = id;
        this.reference = reference;
        this.designation = designation;
        this.prix = prix;
    }

    public Article(String reference, String designation, double prix) {
        this.reference = reference;
        this.designation = designation;
        this.prix = prix;
    }

    //    GETTER & SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
