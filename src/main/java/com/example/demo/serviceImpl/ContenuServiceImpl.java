package com.example.demo.serviceImpl;

import com.example.demo.classes.Article;
import com.example.demo.classes.Commande;
import com.example.demo.classes.Contenu;
import com.example.demo.repository.ArticleRepo;
import com.example.demo.repository.CommandeRepo;
import com.example.demo.repository.ContenuRepo;
import com.example.demo.service.ContenuService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContenuServiceImpl implements ContenuService {
    private ContenuRepo contenuRepo;
    private CommandeRepo commandeRepo;
    private ArticleRepo articleRepo;


    public ContenuServiceImpl(ContenuRepo contenuRepo) {
        this.contenuRepo = contenuRepo;
    }


    /** Fonction qui renvoi le contenu d’une commande donnée*/
    @Override
    public Contenu getContenu(Long commandeId) {
        // il y'aura une erreur là, je le sens
        Commande commande = commandeRepo.findById(commandeId).get();
        return contenuRepo.findByCommande(commande);
    }


    // TODO La vérification lors de l’enregistrement doit se faire sur l’article et sur la commande.
    //     * En gros on doit vérifier si l’article du contenu existe déjà pour la commande en cours
    //     * et si c’est le cas on met simplement la quantité à jour ,
    //     * pareil pour la modification

    @Override
    @Transactional
    public Contenu saveContenu(Contenu contenu, Long commandeId, Long articleId) {
        Article article = articleRepo.findById(articleId).get();
        Commande commande = commandeRepo.findById(commandeId).get();

        try{
            Contenu cont = contenuRepo.findByCommande(commande);
            if(cont != null && cont.getId()>0){
                return new Contenu();
            }

            if (article != null && article.getId()>0){
//                    cont.getQte() =
                return contenuRepo.save(contenu);
            }
            return new Contenu();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new Contenu();
        }
    }

    @Override
    public String deleteContenu(Long id) {
        Contenu cont = contenuRepo.findById(id).orElse(new Contenu());
        if(cont.getId()>0){
            contenuRepo.delete(cont);
            return "Contenu Supprimé";
        }
        return "Erreur";
    }

    @Override
    @Transactional
    public Contenu updateContenu(Contenu contenu, Long commandeId, Long articleId) {
        Article article = articleRepo.findById(articleId).get();
        Commande commande = commandeRepo.findById(commandeId).get();

        try{
            Contenu cont = contenuRepo.findByCommande(commande);
            if(cont != null && cont.getId() != contenu.getId()){
                return new Contenu();
            }
            if (article != null && article.getId()>0){
//                    cont.getQte() =
                return contenuRepo.save(contenu);
            }
            return new Contenu();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new Contenu();
        }
    }
}
