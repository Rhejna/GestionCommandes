package com.example.demo.repository;

import com.example.demo.classes.Client;
import com.example.demo.classes.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepo extends JpaRepository<Commande, Long> {

    Commande findByNumero(int numero);
    List<Commande> findByClient(Client client);
}
