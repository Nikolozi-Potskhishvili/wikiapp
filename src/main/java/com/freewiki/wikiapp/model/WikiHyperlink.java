package com.freewiki.wikiapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hyperlinks")
public class WikiHyperlink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "article_from_id")
    private Article articleFrom;

    @ManyToOne
    @JoinColumn(name = "article_to_id")
    private Article articleTo;


    private Long sectionId;
    private String text;
    private String url;

    public Article getArticleFrom() {
        return articleFrom;
    }

    public void setArticleFrom(Article articleFrom) {
        this.articleFrom = articleFrom;
    }

    public Article getArticleTo() {
        return articleTo;
    }

    public void setArticleTo(Article articleTo) {
        this.articleTo = articleTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }
}
