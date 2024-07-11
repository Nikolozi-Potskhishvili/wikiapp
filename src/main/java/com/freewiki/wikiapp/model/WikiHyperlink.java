package com.freewiki.wikiapp.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

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

    private Long sectionId;

    private String linkText;
    private String linkUrl;

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
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
