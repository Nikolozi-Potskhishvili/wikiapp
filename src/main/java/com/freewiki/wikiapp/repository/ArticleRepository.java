package com.freewiki.wikiapp.repository;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.UpvoteDownvote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    ArrayList<Article> findUserByTitle(String title);
    @Query(value = "SELECT * FROM articles ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Article findRandomArticle();
}
