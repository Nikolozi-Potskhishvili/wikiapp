package com.freewiki.wikiapp.wikisearch;

import com.beust.ah.A;
import com.freewiki.wikiapp.model.Article;

import java.util.List;
import java.util.Map;

public class UpdateArticleScores {

    public static void updateArticleScores(List<Article> articles) {
        Map<Article, Double> pageRank = ArticleImportance.calculatePageRank(articles);
        Map<Article, Double> textQualityMap = TextQuality.getArticleTextQualityMap(articles);
    }
}
