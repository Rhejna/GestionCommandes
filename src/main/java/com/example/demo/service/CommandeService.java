package com.example.demo.service;

import com.example.demo.classes.Commande;

import java.util.List;

public interface CommandeService {
    List<Commande> allCommandes();

    Commande getCommande(int numero);

    Commande saveCommande(Commande commande);

    String deleteCommande(Long id);

    Commande updateCommande(Commande commande);
}
