package com.freewiki.wikiapp.model;

import com.freewiki.wikiapp.wikisearch.ArticleImportance;
import jakarta.persistence.*;

import java.util.*;


@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private MyUser author;

    @ManyToOne
    @JoinColumn(name = "forked_from_id")
    private Article forkedFrom;

    @Column(updatable = false)
    private Date createdAt;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Section> sections = new LinkedList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UpvoteDownvote> upvoteDownvotes = new LinkedList<>();

    @OneToMany(mappedBy = "articleFrom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WikiHyperlink> linksFrom = new LinkedList<>();

    @OneToMany(mappedBy = "articleTo", fetch = FetchType.LAZY)
    private List<WikiHyperlink> linksTo = new LinkedList<>();

    @OneToOne(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArticleQuality articleQuality;



    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MyUser getAuthor() {
        return author;
    }

    public void setAuthor(MyUser author) {
        this.author = author;
    }

    public Article getForkedFrom() {
        return forkedFrom;
    }

    public void setForkedFrom(Article forkedFrom) {
        this.forkedFrom = forkedFrom;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<WikiHyperlink> getLinksFrom() {
        return linksFrom;
    }

    public void setLinksFrom(List<WikiHyperlink> linksFrom) {
        this.linksFrom = linksFrom;
    }

    public List<WikiHyperlink> getLinksTo() {
        return linksTo;
    }

    public void setLinksTo(List<WikiHyperlink> linksTo) {
        this.linksTo = linksTo;
    }

    public ArticleQuality getArticleQuality() {
        return articleQuality;
    }

    public void setArticleQuality(ArticleQuality articleQuality) {
        this.articleQuality = articleQuality;
    }

    public List<UpvoteDownvote> getUpvoteDownvotes() {
        return upvoteDownvotes;
    }

    public void setUpvoteDownvotes(List<UpvoteDownvote> upvoteDownvotes) {
        this.upvoteDownvotes = upvoteDownvotes;
    }
}
