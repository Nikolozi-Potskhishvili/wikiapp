package com.freewiki.wikiapp.services;


import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.User;
import com.freewiki.wikiapp.repository.ArticleRepository;
import com.freewiki.wikiapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article  saveNewArticle(Article article) {
       return articleRepository.save(article);
    }

    public ArrayList<Article> findArticlesByTitle(String title) {
        ArrayList<Article> articles = articleRepository.findUserByTitle(title);
        if(articles.isEmpty()) throw new IllegalArgumentException("Article not found");
        return articles;
    }

    public Article findArticleById(Long id) {
        return articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Article not found"));
    }

    public Article save(Article article) {
        return articleRepository.save(article);
    }
}
