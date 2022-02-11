package com.example.demo.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
@Data //crée des getters et setters
@NoArgsConstructor // cree un constructeur par defaut
@AllArgsConstructor

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

    public Long getId() {
        return id != null ? id : 0;
    }

}
