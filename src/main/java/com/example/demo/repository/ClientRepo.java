package com.example.demo.repository;

import com.example.demo.classes.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findByNumero(int numero);

    Client findByEmail(String email);


}
