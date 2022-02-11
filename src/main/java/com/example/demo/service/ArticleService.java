package com.example.demo.service;


import com.example.demo.classes.Article;

import java.util.List;

public interface ArticleService {

    List<Article> allArticles(); //prototype

    Article getArticle(String reference);

    Article saveArticle(Article article);

    String deleteArticle(Long id);

    Article updateArticle(Article article);
}
