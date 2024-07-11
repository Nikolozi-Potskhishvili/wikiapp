package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.model.WikiHyperlink;
import com.freewiki.wikiapp.repository.HyperlinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HyperlinkService {
    private final HyperlinkRepository hyperlinkRepository;

    public HyperlinkService(HyperlinkRepository hyperlinkRepository) {
        this.hyperlinkRepository = hyperlinkRepository;
    }

}
