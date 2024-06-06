package com.freewiki.wikiapp.repository;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {


}
