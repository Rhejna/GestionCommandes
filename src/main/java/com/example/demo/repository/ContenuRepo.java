package com.example.demo.repository;

import com.example.demo.classes.Article;
import com.example.demo.classes.Commande;
import com.example.demo.classes.Contenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContenuRepo extends JpaRepository<Contenu, Long> {
//    @Query(value = "SELECT u FROM Contenu u, Commande c WHERE u.commande.ref = :")
//    Contenu getByCom(String ref);

    Contenu findByCommande(Commande commande);

//    @Query(value = "SELECT u FROM Contenu u WHERE u.qte = :qte")
//    int getByQte(int qte);
}
