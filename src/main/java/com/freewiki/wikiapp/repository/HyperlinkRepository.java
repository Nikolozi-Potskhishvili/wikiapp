package com.freewiki.wikiapp.repository;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.WikiHyperlink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HyperlinkRepository extends JpaRepository<WikiHyperlink, Long> {
}
