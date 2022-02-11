package com.example.demo.service;

import com.example.demo.classes.Client;

import java.util.List;

public interface ClientService {
    List<Client> allClients();

//    Client getClient(int numero);
    Client getClient(String email);

    Client saveClient(Client client);

    String deleteClient(Long id);

    Client updateClient(Client client);
}
