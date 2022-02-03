package com.example.demo.classes;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
public class Commande implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private int numero;
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;
    private LocalDate date;
    @Column(nullable = false)
    private String statut;

    public Commande() {
    }

    public Commande(Long id, int numero, Client client, LocalDate date, String statut) {
        this.id = id;
        this.numero = numero;
        this.client = client;
        this.date = date;
        this.statut = statut;
    }

    public Commande(int numero, Client client, LocalDate date, String statut) {
        this.numero = numero;
        this.client = client;
        this.date = date;
        this.statut = statut;
    }

    //    GETTER & SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
