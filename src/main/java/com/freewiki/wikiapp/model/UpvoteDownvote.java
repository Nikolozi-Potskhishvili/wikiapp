package com.freewiki.wikiapp.model;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
@Table(name = "upvotes_downvotes")
public class UpvoteDownvote {
    @Id
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private MyUser user;

    private boolean upvote;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public boolean isUpvote() {
        return upvote;
    }

    public void setUpvote(boolean upvote) {
        this.upvote = upvote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
