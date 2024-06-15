package com.freewiki.wikiapp.controllers;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.Paragraph;
import com.freewiki.wikiapp.model.MyUser;
import com.freewiki.wikiapp.model.Section;
import com.freewiki.wikiapp.requests.IsAuthorRequest;
import com.freewiki.wikiapp.responses.IsAuthorResponse;
import com.freewiki.wikiapp.services.ArticleService;
import com.freewiki.wikiapp.services.ParagraphService;
import com.freewiki.wikiapp.services.MyUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ArticleController {
    private final ArticleService articleService;
    private final ParagraphService paragraphService;
    private final MyUserService myUserService;

    @Autowired
    public ArticleController(ArticleService articleService, ParagraphService paragraphService, MyUserService myUserService) {
        this.articleService = articleService;
        this.paragraphService = paragraphService;
        this.myUserService = myUserService;
    }

    @GetMapping("/searchForArticle")
    public String searchArticle(@RequestParam String title, final Model model) {
        ArrayList<Article> articles = articleService.findArticlesByTitle(title);
        model.addAttribute("articles", articles);
        model.addAttribute("title", title);
        return "searchResults";
    }

    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable("id") long id, final Model model,
                             HttpServletRequest request) {
        Article article = articleService.findArticleById(id);
        List<Section> sortedSections = article.getSections().stream()
                .sorted(Comparator.comparingInt(Section::getArticlePosition))
                .collect(Collectors.toList());
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        article.setSections(sortedSections);
        model.addAttribute("article", article);
        model.addAttribute("username", username);
        if(article != null) return "article";
        return null;
    }
/*
    @PostMapping("/deleteParagraph")
    public ResponseEntity<Map<String, String>> deleteParagraph(@RequestBody Map<String, Long> requestData) {
        long articleId = requestData.get("articleId");
        long paragraphId = requestData.get("paragraphId");
        Article article = articleService.deleteParagraph(articleId, paragraphId);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "Paragraph deleted successfully");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseBody);
    }*/

    @PostMapping("/isAuthor")
    @ResponseBody
    public IsAuthorResponse isAuthor(@RequestBody IsAuthorRequest request) {
        long userId = request.getUserId();
        long articleId = request.getArticleId();

        boolean checkResult = articleService.checkAuthor(userId, articleId);
        return checkResult ? IsAuthorResponse.ok() : IsAuthorResponse.notFound();
    }

 /*   @PostMapping("/addNewParagraph")
    public String addNewParagraph(@RequestParam("articleId") long articleId,
                                  @RequestParam("paragraphType") String type,
                                  final Model model) {
        Article article = articleService.addNewParagraph(articleId, type);
        model.addAttribute("article", article);
        return "articleEdit";
    }
*/
    @PostMapping("/changeArticleTitle")
    public String changeArticleName(@RequestParam("articleId") long articleId,
                                            @RequestParam("title") String title, final Model model) {
        Article article = articleService.changeTitle(articleId, title);
        model.addAttribute("article", article);
        return "articleEdit";
    }

    @PostMapping("/createNewArticle")
    public String createNewArticle(@RequestParam String title,
                                   final Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(!(session.getAttribute(username) == null)) {
            return "redirect:/login";
        } else {
            String[] paragraphTypes = {"Summary", "Body", "References"};
            MyUser currnetMyUser = myUserService.findUserByUsername(username);
            Article currentArticle = new Article();
            currentArticle.setAuthor(currnetMyUser);
            currentArticle.setTitle(title);
            for (int i = 1; i <= 3; i++) {
                Section section = new Section();
                Paragraph emptyParagraph = new Paragraph();
                emptyParagraph.setTitle(i + "'th paragraph");
                emptyParagraph.setArticle(currentArticle);
                emptyParagraph.setPosition(0);
                emptyParagraph.setContent("This is a [[link text|http://example.com]] to check.");
                emptyParagraph.setSection(section);
                section.getParagraphs().add(emptyParagraph);
                section.setArticle(currentArticle);
                section.setSectionTitle(paragraphTypes[i - 1]);
                section.setArticlePosition(i);
                currentArticle.getSections().add(section);
            }
            articleService.saveNewArticle(currentArticle);
            model.addAttribute("article", currentArticle);
            return "article";
        }
    }

    @GetMapping("/randomArticle")
    public String getRandomArticle(final Model model, HttpServletRequest request) {
        return "";
    }
}
