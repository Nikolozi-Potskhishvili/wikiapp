package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.model.Paragraph;
import com.freewiki.wikiapp.model.Section;
import com.freewiki.wikiapp.repository.ParagraphRepository;
import com.freewiki.wikiapp.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class SectionService {
    private final SectionRepository sectionRepository;
    private final ParagraphRepository paragraphRepository;
    public SectionService(SectionRepository sectionRepository, ParagraphRepository paragraphRepository) {
        this.sectionRepository = sectionRepository;
        this.paragraphRepository = paragraphRepository;
    }

    public Section addNewParagraph(String title, long sectionId) {
        Section section = sectionRepository.findById(sectionId).get();
        List<Paragraph> paragraphList = section.getParagraphs();
        Paragraph newParagraph = new Paragraph();

        newParagraph.setTitle(title);
        newParagraph.setContent("");
        newParagraph.setSection(section);
        newParagraph.setPosition(paragraphList.size());
        paragraphList.add(newParagraph);
        section.setParagraphs(paragraphList);

        section.setParagraphCount(section.getParagraphCount() + 1);

        sectionRepository.save(section);

        return section;
    }

    public Section deleteParagraph(long sectionId, long paragraphId) {
        Section section = sectionRepository.findById(sectionId).get();
        List<Paragraph> paragraphList = section.getParagraphs();
        Paragraph paragraph = paragraphRepository.findById(paragraphId).get();


        paragraphList.sort(Comparator.comparingInt(Paragraph::getPosition));
        int position = section.getArticlePosition();

        for(int i = position + 1; i <= paragraphList.size(); i++) {
            paragraphList.get(i - 1).setPosition(i - 1);
        }

        paragraphList.remove(paragraph);
        section.setParagraphs(paragraphList);
        sectionRepository.save(section);
        return section;
    }

    public Section changeSectionTitle(long sectionId, String newTitle) {
        Section section = sectionRepository.findById(sectionId).get();
        section.setSectionTitle(newTitle);
        sectionRepository.save(section);
        return section;
    }
}
