package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.model.Paragraph;
import com.freewiki.wikiapp.repository.ParagraphRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParagraphService {
    private final ParagraphRepository paragraphRepository;

    public ParagraphService(ParagraphRepository paragraphRepository) {
        this.paragraphRepository = paragraphRepository;
    }

    public Paragraph addNewParagraph(Paragraph paragraph) {

        return paragraphRepository.save(paragraph);
    }


    public Paragraph updateParagraph(long id, String content) {
        Paragraph paragraphToUpdate = findById(id);
        paragraphToUpdate.setContent(content);
        paragraphRepository.save(paragraphToUpdate);
        return paragraphToUpdate;
    }

    public Paragraph findById(long id) {
        Optional<Paragraph> paragraph = paragraphRepository.findById(id);
        if(paragraph.isPresent()) return paragraph.get();
        throw new IllegalArgumentException("No paragraph with id " + id + " exists");
    }

    public Paragraph changeParagraphTitle(long paragraphId, String title) {
        Paragraph paragraph = findById(paragraphId);
        paragraph.setTitle(title);
        paragraphRepository.save(paragraph);
        return paragraph;
    }
}
