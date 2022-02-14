package com.example.demo.service;

import com.example.demo.classes.Paiement;

import java.util.List;

public interface PaiementService {
    List<Paiement> allPaiements();

    List<Paiement> getPaiementsCommande(Long commandeId);

    Paiement savePaiement(Paiement paiement, Long commandeId);

    String deletePaiement(Long id);

    Paiement updatePaiement(Paiement paiement, Long commandeId);
}
