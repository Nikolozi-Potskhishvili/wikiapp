package com.freewiki.wikiapp.services;

import com.beust.ah.A;
import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.ArticleQuality;
import com.freewiki.wikiapp.model.UpvoteDownvote;
import com.freewiki.wikiapp.repository.ArticleQualityRepository;
import com.freewiki.wikiapp.repository.ArticleRepository;
import com.freewiki.wikiapp.repository.UpvoteDownvoteRepository;
import com.freewiki.wikiapp.wikisearch.ArticleImportance;
import com.freewiki.wikiapp.wikisearch.TextQuality;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleScoreUpdaterService {

    private final ArticleRepository articleRepository;
    private final ArticleQualityRepository articleQualityRepository;
    public ArticleScoreUpdaterService(ArticleRepository articleRepository, ArticleQualityRepository articleQualityRepository, UpvoteDownvoteRepository upvoteDownvoteRepository) {
        this.articleRepository = articleRepository;
        this.articleQualityRepository = articleQualityRepository;
    }

    @Transactional
    @Scheduled(fixedRate = 86400000) // 24 hours in milliseconds
    public void updateArticleScores() {
        List<Article> articles = articleRepository.findAll();
        Map<Article, Double> pageRank = ArticleImportance.calculatePageRank(articles);
        Map<Article, Double> textQualityMap = TextQuality.getArticleTextQualityMap(articles);
        for (Article article : articles) {
            ArticleQuality articleQuality = article.getArticleQuality();
            if (articleQuality == null) {
                articleQuality = new ArticleQuality();
                articleQuality.setArticle(article);
            }
            articleQuality.setPageRankScore(pageRank.get(article));
            articleQuality.setTextQualityScore(1.0);
            articleQualityRepository.save(articleQuality);
        }
    }


}
