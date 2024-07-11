package com.freewiki.wikiapp.wikisearch;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.Paragraph;
import com.freewiki.wikiapp.model.Section;
import com.freewiki.wikiapp.wikimark.TextParser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TextQuality {


    private static int getArticleTextScore(Article article) {

        return 0;
    }

    private double getArticleWordScore(Article article) {
        Set<String> wordsMap = new HashSet<>();
        int wordCount = 0;
        for(Section section : article.getSections()) {
            for(Paragraph paragraph : section.getParagraphs()) {
                String content = TextParser.getParsedText(paragraph.getContent());
                String[] words = content.split("\\s+");
                wordCount += words.length;
                for (String word : words) {
                    wordsMap.add(word.toLowerCase());
                }
            }
        }
        if(wordCount == 0) return 0;
        return (double) (wordsMap.size() * 100) / wordCount;
    }


}
