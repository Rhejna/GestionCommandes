package com.example.demo.serviceImpl;

import com.example.demo.classes.Client;
import com.example.demo.repository.ClientRepo;
import com.example.demo.service.ClientService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public List<Client> allClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client getClient(String email) {
//        return clientRepo.findByNumero(numero);
        return clientRepo.findByEmail(email);
    }

    @Override
    @Transactional
    public Client saveClient(Client client) {
        try{
            Client clt = clientRepo.findByNumero(client.getNumero());
            if (clt != null && clt.getId()>0){
                return new Client();
            }
            return clientRepo.save(client);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new Client();
        }
    }

    @Override
    public String deleteClient(Long id) {
        Client clt = clientRepo.findById(id).orElse(new Client());
        if (clt.getId() > 0){
            clientRepo.delete(clt);
            return "Client Supprimé";

        }
        return "Erreur";
    }

    @Override
    @Transactional
    public Client updateClient(Client client) {
        try{
            Client clt = clientRepo.findByNumero(client.getNumero());
            if (clt != null && clt.getId() != client.getId()) {
                return new Client();
            }
            return clientRepo.save(client);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new Client();
        }
    }
}
