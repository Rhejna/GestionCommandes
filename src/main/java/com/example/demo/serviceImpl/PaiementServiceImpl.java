package com.example.demo.serviceImpl;

import com.example.demo.classes.Paiement;
import com.example.demo.repository.PaiementRepo;
import com.example.demo.service.PaiementService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService{
    private PaiementRepo paiementRepo;

    public PaiementServiceImpl(PaiementRepo paiementRepo) {
        this.paiementRepo = paiementRepo;
    }

    @Override
    public List<Paiement> allPaiements() {
        return paiementRepo.findAll();
    }

    @Override
    @Transactional
    public Paiement savePaiement(Paiement paiement) {
        try{
            Paiement pay = paiementRepo.findByCommande(paiement.getCommande());
            if(pay != null && pay.getId()>0){
                return new Paiement();
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
    public Paiement updatePaiement(Paiement paiement) {
        try{
            Paiement pay = paiementRepo.findByCommande(paiement.getCommande());
            if(pay != null && pay.getId() != paiement.getId()){
                return new Paiement();
            }
            return paiementRepo.save(paiement);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new Paiement();
        }
    }
}
