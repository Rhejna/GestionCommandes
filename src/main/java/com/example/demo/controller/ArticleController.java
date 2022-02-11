package com.example.demo.controller;

import com.example.demo.classes.Article;
import com.example.demo.service.ArticleService;
import com.example.demo.utils.Constantes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constantes.PATH + "article")
@CrossOrigin("*")
public class ArticleController {

    public ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Article> alls() {
        return service.allArticles();
    }

    @GetMapping("/reference/{value}")
    public Article getByReference(@PathVariable String value) {
        return this.service.getArticle(value);
    }

    @PostMapping("/")
    public Article create(@RequestBody Article article) {
        return this.service.saveArticle(article);
    }

    @PutMapping("/")
    public Article update(@RequestBody Article article) {
        return this.service.updateArticle(article);
    }

    @DeleteMapping("/delete/{idArticle}")
    public String delete(@PathVariable Long idArticle) {
        return this.service.deleteArticle(idArticle);
    }
}

