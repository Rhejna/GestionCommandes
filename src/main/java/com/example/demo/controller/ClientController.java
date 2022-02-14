package com.example.demo.controller;

import com.example.demo.classes.Client;
import com.example.demo.service.ClientService;
import com.example.demo.utils.Constantes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constantes.PATH + "client")
@CrossOrigin("*")
public class ClientController {

    public ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Client> allClients() {
        return service.allClients();
    }

    @GetMapping("/email/{value}")
    public Client getByEmail(@PathVariable String value) {
        return this.service.getClient(value);
    }

    @PostMapping("/")
    public Client create(@RequestBody Client client) {
        return this.service.saveClient(client);
    }

    @PostMapping("/numero/{id}")
    public int generateNumber(Long id) {
        return this.service.generateNumero(id);
    }

    @PutMapping("/")
    public Client update(@RequestBody Client client) {
        return this.service.updateClient(client);
    }

    @DeleteMapping("/delete/{idClient}")
    public String delete(@PathVariable Long idClient) {
        return this.service.deleteClient(idClient);
    }
}

