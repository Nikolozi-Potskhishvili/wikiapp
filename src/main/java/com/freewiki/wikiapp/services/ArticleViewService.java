package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.ArticleView;
import com.freewiki.wikiapp.model.MyUser;
import com.freewiki.wikiapp.repository.ArticleViewRepository;
import org.springframework.stereotype.Service;

@Service

public class ArticleViewService {
    private final ArticleViewRepository articleViewRepository;

    public ArticleViewService(ArticleViewRepository articleViewRepository) {
        this.articleViewRepository = articleViewRepository;
    }

    public void addViewToArticle(Article article, MyUser user, String remoteAddr) {
        ArticleView articleView = new ArticleView();
        articleView.setMyUser(user);
        articleView.setArticle(article);
        articleView.setIpAddress(remoteAddr);
        articleViewRepository.save(articleView);
    }
}
