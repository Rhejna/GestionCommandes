package com.example.demo.controller;

import com.example.demo.classes.Commande;
import com.example.demo.service.CommandeService;
import com.example.demo.utils.Constantes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constantes.PATH + "commande")
@CrossOrigin("*")
public class CommandeController {
    public CommandeService service;

    public CommandeController(CommandeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Commande> alls() {
        return service.allCommandes();
    }

    @GetMapping("/numero/{value}")
    public Commande getByNumero(@PathVariable int value) {
        return this.service.getCommande(value);
    }

    @PostMapping("/")
    public Commande create(@RequestBody Commande commande) {
        return this.service.saveCommande(commande);
    }

    @PutMapping("/")
    public Commande update(@RequestBody Commande commande) {
        return this.service.updateCommande(commande);
    }

    @DeleteMapping("/delete/{idCommande}")
    public String delete(@PathVariable Long idCommande) {
        return this.service.deleteCommande(idCommande);
    }
}
