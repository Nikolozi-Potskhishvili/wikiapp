package com.freewiki.wikiapp.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "article_views")
public class ArticleView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "time")
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    MyUser myUser;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    Article article;

    @PrePersist
    protected void onCreate() {
        time = new Timestamp(System.currentTimeMillis());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Timestamp getTime() {
        return time;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }
}
