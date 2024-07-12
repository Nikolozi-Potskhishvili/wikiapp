package com.freewiki.wikiapp.repository;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.ArticleQuality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleQualityRepository extends JpaRepository<ArticleQuality, Long> {
}
