package com.example.demo.service;

import com.example.demo.classes.Commande;
import com.example.demo.classes.Contenu;

import java.util.List;

public interface ContenuService {

    Contenu getContenu(Long commandeId);

//    Contenu saveContenu(Contenu contenu);
    Contenu saveContenu(Contenu contenu, Long commandeId, Long articleId);

    String deleteContenu(Long id);

//    Contenu updateContenu(Contenu contenu);
    Contenu updateContenu(Contenu contenu, Long commandeId, Long articleId);
}
