package com.freewiki.wikiapp.wikisearch;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.Paragraph;
import com.freewiki.wikiapp.model.Section;
import com.freewiki.wikiapp.wikimark.TextParser;

import java.util.*;

public class TextQuality {


    public static Map<Article, Double> getArticleTextQualityMap(List<Article> articles) {
        Map<Article, Double> res = new HashMap<>();
        for (Article article : articles) {
            double wordDiversityScore = getArticleWordScore(article);
            double readabilityScore = calculateReadabilityScore(article) / 100;

            double finalScore = (wordDiversityScore + 4 * readabilityScore) / 4;
            res.put(article, finalScore);
        }

        return res;
    }

    private static double getArticleWordScore(Article article) {
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

    private static double calculateReadabilityScore(Article article) {
        int totalWords = 0;
        int totalSentences = 0;
        int totalSyllables = 0;

        for (Section section : article.getSections()) {
            for (Paragraph paragraph : section.getParagraphs()) {
                String content = TextParser.getParsedText(paragraph.getContent());
                String[] sentences = content.split("[.!?]\\s*");
                totalSentences += sentences.length;
                for (String sentence : sentences) {
                    String[] words = sentence.split("\\s+");
                    totalWords += words.length;
                    for (String word : words) {
                        totalSyllables += countSyllables(word);
                    }
                }
            }
        }

        if (totalSentences == 0 || totalWords == 0) return 0;

        double avgWordsPerSentence = (double) totalWords / totalSentences;
        double avgSyllablesPerWord = (double) totalSyllables / totalWords;

        // Flesch-Kincaid readability score calculation
        return 206.835 - 1.015 * avgWordsPerSentence - 84.6 * avgSyllablesPerWord;
    }

    private static int countSyllables(String word) {
        // Simple syllable count heuristic
        return word.replaceAll("e$", "")
                .replaceAll("[aeiouyAEIOUY]{2,}", "a")
                .replaceAll("[^aeiouyAEIOUY]+", "")
                .length();
    }

}
