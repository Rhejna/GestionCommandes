package com.example.demo.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity //for hibernate
@Table
@Data //crée des getters et setters
@NoArgsConstructor // cree un constructeur par defaut
@AllArgsConstructor

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

    public Long getId() {
        return id != null ? id : 0;
    }
}
