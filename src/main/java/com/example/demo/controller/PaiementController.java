package com.example.demo.controller;

import com.example.demo.classes.Paiement;
import com.example.demo.service.PaiementService;
import com.example.demo.utils.Constantes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constantes.PATH + "paiement")
@CrossOrigin("*")
public class PaiementController {

    public PaiementService service;

    public PaiementController(PaiementService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Paiement> alls() {
        return service.allPaiements();
    }

    @PostMapping("/")
    public Paiement create(@RequestBody Paiement paiement) {
        return this.service.savePaiement(paiement);
    }

    @PutMapping("/")
    public Paiement update(@RequestBody Paiement paiement) {
        return this.service.updatePaiement(paiement);
    }

    @DeleteMapping("/delete/{idPaiement}")
    public String delete(@PathVariable Long idPaiement) {
        return this.service.deletePaiement(idPaiement);
    }
}

