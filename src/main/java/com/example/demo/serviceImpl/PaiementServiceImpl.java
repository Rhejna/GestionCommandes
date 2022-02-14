package com.example.demo.serviceImpl;

import com.example.demo.classes.Commande;
import com.example.demo.classes.Contenu;
import com.example.demo.classes.Paiement;
import com.example.demo.repository.CommandeRepo;
import com.example.demo.repository.ContenuRepo;
import com.example.demo.repository.PaiementRepo;
import com.example.demo.service.PaiementService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService{
    private PaiementRepo paiementRepo;
    private CommandeRepo commandeRepo;
    private ContenuRepo contenuRepo;

    public PaiementServiceImpl(PaiementRepo paiementRepo) {
        this.paiementRepo = paiementRepo;
    }

    // TODO
    //  On doit vérifier la cohérence des montants lors de l’enregistrement, modification ou suppression
    //  et mettre a jour le statut de la commande correspondante
    //  Absence d’une fonction qui renverrait la liste des paiements d’une commande

    @Override
    public List<Paiement> allPaiements() {
        return paiementRepo.findAll();
    }

    @Override
    public List<Paiement> getPaiementsCommande(Long commandeId){
        Commande commande = commandeRepo.findById(commandeId).get();
        return paiementRepo.findByCommande(commande);

    }

    @Override
    @Transactional
    public Paiement savePaiement(Paiement paiement, Long commandeId){
        try{
            Commande commande = commandeRepo.findById(commandeId).get();
            Contenu contenu = contenuRepo.findByCommande(commande);
            Paiement pay = paiementRepo.getByCommande(commande);
            if(pay != null && pay.getId()>0){
                return new Paiement();
            }
            if (pay.getMontant() == contenu.getPrix_total()){
                commande.setStatut("Paiement complet");
            }else{
                commande.setStatut("Paiement incomplet");
            }
            return paiementRepo.save(paiement);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new Paiement();
        }
    }

    @Override
    public String deletePaiement(Long id) {
        Paiement pay = paiementRepo.findById(id).orElse(new Paiement());
        if(pay.getId()>0){
            paiementRepo.delete(pay);
            return "Paiement Supprimé";
        }
        return "Erreur";
    }

    @Override
    @Transactional
    public Paiement updatePaiement(Paiement paiement, Long commandeId) {
        try{
            Commande commande = commandeRepo.findById(commandeId).get();
            Contenu contenu = contenuRepo.findByCommande(commande);
            Paiement pay = paiementRepo.getByCommande(commande);
            if(pay != null && pay.getId() != paiement.getId()){
                return new Paiement();
            }
            if (pay.getMontant() == contenu.getPrix_total()){
                commande.setStatut("Paiement complet");
            }else{
                commande.setStatut("Paiement incomplet");
            }
            return paiementRepo.save(paiement);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new Paiement();
        }
    }
}
