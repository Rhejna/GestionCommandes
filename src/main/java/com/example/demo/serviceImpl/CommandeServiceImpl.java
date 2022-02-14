package com.example.demo.serviceImpl;

import com.example.demo.classes.Client;
import com.example.demo.classes.Commande;
import com.example.demo.repository.ClientRepo;
import com.example.demo.repository.CommandeRepo;
import com.example.demo.service.CommandeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
public class CommandeServiceImpl implements CommandeService {
    private CommandeRepo commandeRepo;
    private ClientRepo clientRepo;
    Random random = new Random();

    public CommandeServiceImpl(CommandeRepo commandeRepo) {
        this.commandeRepo = commandeRepo;
    }

    // TODO Absence d’une fonction qui génère un numéro de commande
    //  Absence d’une fonction qui renvoie la liste des commandes pour un client donné

    @Override
    public int generateNumero(Long id) {
        int randNumb = random.nextInt(10000);
        Commande comm = commandeRepo.getById(id);
        try{
            List<Commande> commandeList = commandeRepo.findAll();
            for (Commande commande : commandeList){
                if (commande.getNumero() == randNumb){

                    int newRandNumb = random.nextInt(10000);
                    comm.setNumero(newRandNumb);

                    return newRandNumb;

                }
            }
            comm.setNumero(randNumb);
            return randNumb;
        }catch (Exception e) {
            System.out.println(e.getMessage());

            int newRandNumb = random.nextInt(10000);
            comm.setNumero(newRandNumb);
            return newRandNumb;
        }

    }

    @Override
    public List<Commande> allCommandes() {
        return commandeRepo.findAll();
    }

    @Override
    public List<Commande> getCommandesClient(Long clientId) {
        Client client = clientRepo.findById(clientId).get();
        return commandeRepo.findByClient(client);
    }

    @Override
    public Commande getCommande(int numero) {
        return commandeRepo.findByNumero(numero);
    }

    @Override
    @Transactional
    public Commande saveCommande(Commande commande) {
        try{
        Commande com = commandeRepo.findByNumero(commande.getNumero());
        if (com != null && com.getId() >0){
            return new Commande();
        }
        return commandeRepo.save(commande);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new Commande();
        }
    }

    @Override
    public String deleteCommande(Long id) {
        Commande com = commandeRepo.findById(id).orElse(new Commande());
        if (com.getId() > 0) {
            commandeRepo.delete(com);
            return "Commande Supprimée !";
        }
        return "Erreur";
    }

    @Override
    @Transactional
    public Commande updateCommande(Commande commande) {
        try {
            Commande com = commandeRepo.findByNumero(commande.getNumero());
            if (com != null && com.getId() != commande.getId()) {
                return new Commande();
            }
            return commandeRepo.save(commande);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Commande();
        }
    }
}
