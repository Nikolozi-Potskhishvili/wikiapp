package com.freewiki.wikiapp.repository;

import com.freewiki.wikiapp.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    ArrayList<Article> findUserByTitle(String title);
}
