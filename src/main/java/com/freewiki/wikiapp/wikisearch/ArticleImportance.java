package com.freewiki.wikiapp.wikisearch;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.WikiHyperlink;

import java.util.*;
import java.util.stream.Collectors;

public class ArticleImportance {
    private static final double DAMPING_FACTOR = 0.85;
    private static final int MAX_ITERATIONS = 100;
    private static final double MIN_DELTA = 0.0001;

    public static Map<Article, Double> calculatePageRank(List<Article> articles) {
        Map<Article, Set<Article>> incomingLinks = new HashMap<>();
        Map<Article, List<Article>> outgoingLinks = new HashMap<>();
        Map<Article, Double> pageRanks = new HashMap<>();
        int totalArticles = articles.size();

        // Initialize incoming and outgoing links
        for (Article article : articles) {
            outgoingLinks.put(article, article.getLinksFrom().stream()
                    .map(WikiHyperlink::getArticleTo)
                    .collect(Collectors.toList()));
            for (WikiHyperlink link : article.getLinksTo()) {
                incomingLinks.computeIfAbsent(link.getArticleFrom(), k -> new HashSet<>()).add(article);
            }
            pageRanks.put(article, 1.0 / totalArticles);
        }

        boolean converged = false;
        int iteration = 0;

        while (!converged && iteration < MAX_ITERATIONS) {
            Map<Article, Double> newPageRanks = new HashMap<>();
            converged = true;

            for(Article article : pageRanks.keySet()) {
                double rankSum = 0.0;

                if (incomingLinks.containsKey(article)) {
                    for (Article articleFrom : incomingLinks.get(article)) {
                        rankSum += pageRanks.get(articleFrom) / outgoingLinks.get(article).size();
                    }
                }

                double newRank = (1 - DAMPING_FACTOR) / totalArticles + DAMPING_FACTOR * rankSum;
                newPageRanks.put(article, newRank);

                if (Math.abs(newRank - pageRanks.get(article)) > MIN_DELTA) {
                    converged = false;
                }
            }

            pageRanks = newPageRanks;
            iteration++;
        }

        return pageRanks;
    }
}
