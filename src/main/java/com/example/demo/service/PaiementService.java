package com.example.demo.service;

import com.example.demo.classes.Paiement;

import java.util.List;

public interface PaiementService {
    List<Paiement> allPaiements();

    Paiement savePaiement(Paiement paiement);

    String deletePaiement(Long id);

    Paiement updatePaiement(Paiement paiement);
}
