package com.freewiki.wikiapp.controllers;

import com.freewiki.wikiapp.model.Article;
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
    public String editParagraph(@RequestParam("paragraphId") Long paragraphId,
                                @RequestParam("articleId") Long articleId, Model model) {
        Paragraph paragraph = paragraphService.findById(paragraphId);
        model.addAttribute("paragraph", paragraph);
        model.addAttribute("articleId", articleId);
        return "editParagraph";
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
