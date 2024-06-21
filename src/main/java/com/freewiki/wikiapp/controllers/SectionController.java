package com.freewiki.wikiapp.controllers;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.Section;
import com.freewiki.wikiapp.repository.ArticleRepository;
import com.freewiki.wikiapp.services.ArticleService;
import com.freewiki.wikiapp.services.SectionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SectionController {
    private final SectionService sectionService;
    private final ArticleService articleService;

    @Autowired
    public SectionController(SectionService sectionService, ArticleService articleService) {
        this.sectionService = sectionService;
        this.articleService = articleService;
    }

    @PostMapping("/addNewParagraph")
    public String addNewParagraph(@RequestParam("articleId") long articleId,
                                  @RequestParam("paragraphTitle") String title,
                                  @RequestParam("sectionId") long sectionId,
                                  final Model model) {
        Article article = articleService.findArticleById(articleId);
        Section section = sectionService.addNewParagraph(title, sectionId);
        return "redirect:/editArticle/" + articleId;
    }

    @PostMapping("/deleteParagraph")

    public ResponseEntity<String> deleteParagraph(@RequestParam("articleId") long articleId,
                                                  @RequestParam("sectionId") long sectionId,
                                                  @RequestParam("paragraphId") long paragraphId,
                                                  final Model model) {
        Section section = sectionService.deleteParagraph(sectionId, paragraphId);
        return ResponseEntity.ok("Paragraph deleted successfully");
    }

    @PostMapping("/changeSectionTitle")
    public String changeSectionTitle(@RequestParam("articleId") long articleId,
                                   @RequestParam("sectionId") long sectionId,
                                   @RequestParam("newTitle") String newTitle) {

        Section section = sectionService.changeSectionTitle(sectionId, newTitle);
        return "redirect:/editArticle/" + articleId;
    }

}
