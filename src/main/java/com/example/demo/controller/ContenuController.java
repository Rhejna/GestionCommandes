package com.example.demo.controller;

import com.example.demo.classes.Commande;
import com.example.demo.classes.Contenu;
import com.example.demo.service.ContenuService;
import com.example.demo.utils.Constantes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constantes.PATH + "contenu")
@CrossOrigin("*")
public class ContenuController {

    public ContenuService service;

    public ContenuController(ContenuService service) {
        this.service = service;
    }



    @GetMapping("/commande/{commandeId}")
    public Contenu getByCommande(@PathVariable Long commandeId) {
        return this.service.getContenu(commandeId);
    }

    @PostMapping("/")
    public Contenu create(@RequestBody Contenu contenu) {
        return this.service.saveContenu(contenu);
    }

    @PutMapping("/")
    public Contenu update(@RequestBody Contenu contenu) {
        return this.service.updateContenu(contenu);
    }

    @DeleteMapping("/delete/{idContenu}")
    public String delete(@PathVariable Long idContenu) {
        return this.service.deleteContenu(idContenu);
    }
}

