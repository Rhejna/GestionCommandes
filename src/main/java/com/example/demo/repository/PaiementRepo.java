package com.example.demo.repository;

import com.example.demo.classes.Article;
import com.example.demo.classes.Commande;
import com.example.demo.classes.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementRepo extends JpaRepository<Paiement, Long>{
    @Query(value = "SELECT u FROM Commande u WHERE u.commande = :com")
    Paiement getByCommande(Commande commande);

    List<Paiement> findByCommande(Commande commande);

}
