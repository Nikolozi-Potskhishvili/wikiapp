package com.freewiki.wikiapp.model;

import jakarta.persistence.*;

@Entity
@Table(name ="article_quality")
public class ArticleQuality {
    @Id
    private Long articleId;

    private Double textQualityScore;
    private Double pageRankScore;
    private Double finalScore;
    @OneToOne()
    @MapsId
    @JoinColumn(name = "article_id")
    private Article article;


    public Long getArticleId() {
        return articleId;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Double getTextQualityScore() {
        return textQualityScore;
    }

    public void setTextQualityScore(Double textQualityScore) {
        this.textQualityScore = textQualityScore;
    }

    public Double getPageRankScore() {
        return pageRankScore;
    }

    public void setPageRankScore(Double pageRankScore) {
        this.pageRankScore = pageRankScore;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
