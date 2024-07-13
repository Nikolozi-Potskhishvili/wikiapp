package com.freewiki.wikiapp.repository;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.Section;
import com.freewiki.wikiapp.model.UpvoteDownvote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UpvoteDownvoteRepository extends JpaRepository<UpvoteDownvote, Long> {
    @Query("SELECT u FROM UpvoteDownvote u WHERE u.article IN :articles")
    List<UpvoteDownvote> findAllByArticles(@Param("articles") List<Article> articles);}
