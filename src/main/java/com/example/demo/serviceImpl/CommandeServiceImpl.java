package com.example.demo.serviceImpl;

import com.example.demo.classes.Commande;
import com.example.demo.repository.CommandeRepo;
import com.example.demo.service.CommandeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    private CommandeRepo commandeRepo;

    public CommandeServiceImpl(CommandeRepo commandeRepo) {
        this.commandeRepo = commandeRepo;
    }

    @Override
    public List<Commande> allCommandes() {
        return commandeRepo.findAll();
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
