package UnitTests;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.WikiHyperlink;
import com.freewiki.wikiapp.wikisearch.ArticleImportance;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.*;

public class PageRankCalculatorTest {

    @Test
    public void testCalculatePageRank() {
        // Create articles
        Article articleA = new Article();
        Article articleB = new Article();
        Article articleC = new Article();

        articleA.setTitle("A");
        articleB.setTitle("B");
        articleC.setTitle("C");

        // Create links
        WikiHyperlink link1 = new WikiHyperlink();
        WikiHyperlink link2 = new WikiHyperlink();
        WikiHyperlink link3 = new WikiHyperlink();
        WikiHyperlink link4 = new WikiHyperlink();
        WikiHyperlink link5 = new WikiHyperlink();

        // Set links between articles
        link1.setArticleFrom(articleA);
        link1.setArticleTo(articleB);
        link2.setArticleFrom(articleA);
        link2.setArticleTo(articleC);
        link3.setArticleFrom(articleB);
        link3.setArticleTo(articleA);
        link4.setArticleFrom(articleC);
        link4.setArticleTo(articleA);
        link5.setArticleFrom(articleC);
        link5.setArticleTo(articleB);

        // Add links to articles
        articleA.getLinksFrom().add(link1);
        articleA.getLinksFrom().add(link2);
        articleB.getLinksTo().add(link1);
        articleC.getLinksTo().add(link2);

        articleB.getLinksFrom().add(link3);
        articleA.getLinksTo().add(link3);

        articleC.getLinksFrom().add(link4);
        articleA.getLinksTo().add(link4);

        articleC.getLinksFrom().add(link5);
        articleB.getLinksTo().add(link5);

        // Add articles to a list
        List<Article> articles = Arrays.asList(articleA, articleB, articleC);

        // Calculate PageRank
        Map<Article, Double> pageRanks = ArticleImportance.calculatePageRank(articles);

        // Check if PageRank values are as expected
        assertNotNull(pageRanks);
        assertEquals(3, pageRanks.size());
        double totalPageRank = pageRanks.values().stream().mapToDouble(Double::doubleValue).sum();
        assertEquals(1.0, totalPageRank, 0.0001); // Ensure the sum of all PageRank values is 1.0

        // Print PageRank values
        pageRanks.forEach((article, rank) -> {
            System.out.println("Article: " + article.getTitle() + " PageRank: " + rank);
        });
    }
}



