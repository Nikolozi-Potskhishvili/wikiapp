package com.freewiki.wikiapp.controllers;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.Paragraph;
import com.freewiki.wikiapp.model.ParagraphUpdateRequest;
import com.freewiki.wikiapp.services.ArticleService;
import com.freewiki.wikiapp.services.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParagraphController {
    private final ParagraphService paragraphService;
    private final ArticleService articleService;

    @Autowired
    public ParagraphController(ParagraphService paragraphService, ArticleService articleService) {
        this.paragraphService = paragraphService;
        this.articleService = articleService;
    }

    @PostMapping("/updateParagraph")
    @ResponseBody
    public ResponseEntity<?> updateParagraph(@RequestBody ParagraphUpdateRequest request) {
        // Find the paragraph by position in the database and update its content
        Article article = articleService.findArticleById(request.getArticleId());
        for (Paragraph paragraph : article.getParagraphs()) {
            if (paragraph.getId() == (request.getId())) {
                paragraph.setContent(request.getContent());
                articleService.save(article); // Save the updated article
                break;
            }
        }
        return ResponseEntity.ok().body("Paragraph updated successfully");
    }

}
