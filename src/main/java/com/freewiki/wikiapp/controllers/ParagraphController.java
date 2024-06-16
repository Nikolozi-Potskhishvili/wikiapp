package com.freewiki.wikiapp.controllers;

import com.freewiki.wikiapp.model.Paragraph;
import com.freewiki.wikiapp.requests.ParagraphUpdateRequest;
import com.freewiki.wikiapp.services.ArticleService;
import com.freewiki.wikiapp.services.ParagraphService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ParagraphController {
    private final ParagraphService paragraphService;
    private final ArticleService articleService;

    @Autowired
    public ParagraphController(ParagraphService paragraphService, ArticleService articleService) {
        this.paragraphService = paragraphService;
        this.articleService = articleService;
    }
    @GetMapping("/editParagraph")
    public String editParagraph(@RequestParam("sectionId") Long sectionId,
                                @RequestParam("paragraphId") Long paragraphId,
                                @RequestParam("articleId") Long articleId,
                                final Model model) {
        Paragraph paragraph = paragraphService.findById(paragraphId);
        model.addAttribute("paragraph", paragraph);
        model.addAttribute("sectionId", sectionId);
        model.addAttribute("articleId", articleId);
        return "editParagraph";
    }


    @PostMapping("/changeParagraphTitle")
    public String changeParagraphTitle(@RequestParam("articleId") long articleId,
                                      @RequestParam("paragraphId") long paragraphId,
                                      @RequestParam("title") String title,
                                      final Model model) {
        Paragraph paragraph = paragraphService.changeParagraphTitle(paragraphId, title);
        model.addAttribute("articleId", articleId);
        model.addAttribute("paragraph", paragraph);
        return "redirect:/editParagraph?sectionId=" +  paragraph.getSection().getId() + "&paragraphId=" + paragraphId + "&articleId=" + articleId;
    }

    @PostMapping("/updateParagraph")
    public ResponseEntity<Object> updateParagraph(@RequestBody ParagraphUpdateRequest request) throws JSONException {
        paragraphService.updateParagraph(request.getParagraphId(), request.getContent());
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "Paragraph updated successfully");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseBody);
    }

}
