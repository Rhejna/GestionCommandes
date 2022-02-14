package com.example.demo.service;

import com.example.demo.classes.Commande;

import java.util.List;

public interface CommandeService {
    int generateNumero(Long id);

    List<Commande> allCommandes();

    List<Commande> getCommandesClient(Long clientId);

    Commande getCommande(int numero);

    Commande saveCommande(Commande commande);

    String deleteCommande(Long id);

    Commande updateCommande(Commande commande);
}
