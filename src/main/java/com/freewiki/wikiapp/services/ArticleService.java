package com.freewiki.wikiapp.services;


import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.Paragraph;
import com.freewiki.wikiapp.model.Section;
import com.freewiki.wikiapp.repository.ArticleRepository;
import com.freewiki.wikiapp.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final SectionRepository sectionRepository;
    public ArticleService(ArticleRepository articleRepository, SectionRepository sectionRepository) {
        this.articleRepository = articleRepository;
        this.sectionRepository = sectionRepository;
    }

    public Article  saveNewArticle(Article article) {
       return articleRepository.save(article);
    }

    public ArrayList<Article> findArticlesByTitle(String title) {
        ArrayList<Article> articles = articleRepository.findUserByTitle(title);
        if(articles.isEmpty()) throw new IllegalArgumentException("Article not found");
        return articles;
    }

    public Article findArticleById(Long articleId) {
        return articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("Article not found"));
    }

    public Article changeTitle(Long articleId, String title) {
        Article article = findArticleById(articleId);
        article.setTitle(title);
        articleRepository.save(article);
        return article;
    }

    public Article save(Article article) {
        return articleRepository.save(article);
    }

/*
    public Article addNewParagraph(long articleId, String type) {
        Article article = findArticleById(articleId);

        List<Paragraph> paragraphs = article.getParagraphs();

        Paragraph paragraph = new Paragraph();
        paragraph.setType(type);
        paragraph.setArticle(article);
        paragraph.setContent("");
        paragraph.setPosition(paragraphs.size());
        paragraphs.add(paragraph);
        articleRepository.save(article);
        return article;
    }
*/

  /*  public Article deleteParagraph(long articleId, long paragraphId) {
        Article article = findArticleById(articleId);
        article.getParagraphs().removeIf(paragraph -> paragraph.getId().equals(paragraphId));
        articleRepository.save(article);
        return article;
    }*/

    public boolean checkAuthor(long userId, long articleId) {
        Article article = findArticleById(articleId);
        return article.getAuthor().getId().equals(userId);
    }

    public Article addNewSections(long articleId, String title) {
        Article article = findArticleById(articleId);
        List<Section> sections = article.getSections();
        Section section = new Section();
        section.setArticle(article);
        section.setSectionTitle(title);
        section.setParagraphs(new ArrayList<>());
        section.setParagraphCount(0);
        section.setArticlePosition(sections.size());
        sections.add(section);

        articleRepository.save(article);

        return article;
    }

    public Article deleteSection(long articleId, long sectionId) {
        Article article = findArticleById(articleId);
        List<Section> sections = article.getSections();
        Section section = sectionRepository.findById(sectionId).get();
        sections.sort(Comparator.comparingInt(Section::getArticlePosition));
        int sectionPosition = section.getArticlePosition();

        for(int i = sectionPosition + 1; i <= sections.size(); i++) {
            sections.get(i - 1).setArticlePosition(i - 1);
        }
        sections.remove(section);
        article.setSections(sections);
        articleRepository.save(article);
        return article;
    }
}
