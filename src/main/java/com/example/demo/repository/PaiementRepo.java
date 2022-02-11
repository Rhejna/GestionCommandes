package com.example.demo.repository;

import com.example.demo.classes.Commande;
import com.example.demo.classes.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepo extends JpaRepository<Paiement, Long>{
    Paiement findByCommande(Commande commande);
}
