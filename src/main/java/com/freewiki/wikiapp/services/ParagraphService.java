package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.model.Paragraph;
import com.freewiki.wikiapp.repository.ParagraphRepository;
import org.springframework.stereotype.Service;

@Service
public class ParagraphService {
    private ParagraphRepository paragraphRepository;

    public Paragraph addNewParagraph(Paragraph paragraph) {
        return paragraphRepository.save(paragraph);
    }
}
