package com.example.demo.serviceImpl;

import com.example.demo.classes.Client;
import com.example.demo.classes.Commande;
import com.example.demo.repository.ClientRepo;
import com.example.demo.service.ClientService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepo clientRepo;
    Random random = new Random();

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
    // TODO Absence d’une fonction qui génère le numéro client
    public int generateNumero(Long id) {
        int randNumb = random.nextInt(10000);
        Client clt = clientRepo.getById(id);
        try{
            List<Client> clientList = clientRepo.findAll();
            for (Client client : clientList){
                if (client.getNumero() == randNumb){

                    int newRandNumb = random.nextInt(10000);
                    clt.setNumero(newRandNumb);

                    return newRandNumb;

                }
            }
            clt.setNumero(randNumb);
            return randNumb;
        }catch (Exception e) {
            System.out.println(e.getMessage());

            int newRandNumb = random.nextInt(10000);
            clt.setNumero(newRandNumb);
            return newRandNumb;
        }
    }

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
