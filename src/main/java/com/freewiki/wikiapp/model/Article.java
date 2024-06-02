package com.freewiki.wikiapp.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.security.Timestamp;


@Entity
@Table
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "forked_from_id")
    private Article forkedFrom;

    @Column(updatable = false)
    private Timestamp createdAt;


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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Article getForkedFrom() {
        return forkedFrom;
    }

    public void setForkedFrom(Article forkedFrom) {
        this.forkedFrom = forkedFrom;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}
