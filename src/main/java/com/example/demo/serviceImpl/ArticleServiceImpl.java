package com.example.demo.serviceImpl;

import com.example.demo.classes.Article;
import com.example.demo.repository.ArticleRepo;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    // @Autowired, déconseiller parce que deprecive
    private ArticleRepo articleRepo;

    public ArticleServiceImpl(ArticleRepo articleRepo){
        this.articleRepo = articleRepo;
    }


    @Override
    public List<Article> allArticles() {
        return articleRepo.findAll();
    }

    @Override
    public Article getArticle(String reference) {
        return articleRepo.findByReference(reference);
    }

    @Override
    @Transactional
    public Article saveArticle(Article article) {
        try {
            Article bean = articleRepo.findByReference(article.getReference());
            if (bean != null && bean.getId() > 0) {
                return new Article();
            }
            return articleRepo.save(article);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Article();
        }
    }

    @Override
    @Transactional
    public Article updateArticle(Article article) {
        try {
            Article bean = articleRepo.findByReference(article.getReference());
            if (bean != null && bean.getId() != article.getId()) {
                return new Article();
            }
            return articleRepo.save(article);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Article();
        }
    }

    @Override
    public String deleteArticle(Long id) {
        Article bean = articleRepo.findById(id).orElse(new Article());
        if (bean.getId() > 0) {
            articleRepo.delete(bean);
            return "Supprimer !";
        }
        return "Erreur";
    }
}
