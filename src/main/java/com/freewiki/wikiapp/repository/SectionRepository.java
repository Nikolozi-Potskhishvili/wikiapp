package com.freewiki.wikiapp.repository;


import com.freewiki.wikiapp.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
}
