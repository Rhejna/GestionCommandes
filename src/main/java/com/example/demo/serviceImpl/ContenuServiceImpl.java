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

    @Override
    public Contenu getContenu(Long commandeId) {
        // il y'aura une erreur là, je le sens
        Commande commande = commandeRepo.findById(commandeId).get();
        return contenuRepo.findByCommande(commande);
    }

    @Override
    @Transactional
    public Contenu saveContenu(Contenu contenu) {
        // IDK, this is suspish asf
//        Commande commande = commandeRepo.findById(commandeId).get();
//        Article article = articleRepo.findById(articleId).get();
//        Contenu contenu2 =  new Contenu();
//        contenu2.setCommande(commande);
//        contenu2.setArticle(article);
//        contenu2.setPrix_total(contenu.getPrix_total());
//        contenu2.setQte(contenu.getQte());
//        return contenuRepo.save(contenu2);

        try{
            Contenu cont = contenuRepo.findByCommande(contenu.getCommande());
            if(cont != null && cont.getId()>0){
                return new Contenu();
            }
            return contenuRepo.save(contenu);
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
    public Contenu updateContenu(Contenu contenu) {
        try{
            Contenu cont = contenuRepo.findByCommande(contenu.getCommande());
            if(cont != null && cont.getId() != contenu.getId()){
                return new Contenu();
            }
            return contenuRepo.save(contenu);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new Contenu();
        }
    }
}
