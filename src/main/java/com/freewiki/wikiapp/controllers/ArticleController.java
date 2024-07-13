package com.freewiki.wikiapp.controllers;

import com.freewiki.wikiapp.model.*;
import com.freewiki.wikiapp.requests.IsAuthorRequest;
import com.freewiki.wikiapp.responses.IsAuthorResponse;
import com.freewiki.wikiapp.services.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ArticleController {
    private final ArticleService articleService;
    private final SectionService sectionService;
    private final MyUserService myUserService;
    private final UpvoteDownvoteService upvoteDownvoteService;

    @Autowired
    public ArticleController(ArticleService articleService, ParagraphService paragraphService, SectionService sectionService, MyUserService myUserService, UpvoteDownvoteService upvoteDownvoteService) {
        this.articleService = articleService;
        this.sectionService = sectionService;
        this.myUserService = myUserService;
        this.upvoteDownvoteService = upvoteDownvoteService;
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

    @PostMapping("/article/setUpvoteDownvote")
    public ResponseEntity<Object> setUpvoteDownvote(@RequestParam("articleId") long articleId,
                                                    @RequestParam("isUpvote") boolean isUpvote, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }
        MyUser user = myUserService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        Article article = articleService.findArticleById(articleId);
        if (article == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Article not found");
        }
        UpvoteDownvote upvoteDownvote = new UpvoteDownvote();
        upvoteDownvote.setUpvote(isUpvote);
        upvoteDownvote.setArticle(article);
        upvoteDownvote.setUser(user);

        UpvoteDownvote result = upvoteDownvoteService.setUpvoteDownvote(upvoteDownvote);

        if (result != null && result.getId() != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to set upvote/downvote");
        }
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

    @PostMapping("/changeArticleTitle")
    public String changeArticleName(@RequestParam("articleId") long articleId,
                                            @RequestParam("title") String title, final Model model) {
        Article article = articleService.changeTitle(articleId, title);
        return "redirect:/editArticle/" + articleId;
    }

    @GetMapping("/editArticle/{articleId}")
    public String getArticleEditPage(@PathVariable("articleId") long articleId, final Model model,
                                     HttpServletRequest request) {
        Article article = articleService.findArticleById(articleId);
        List<Section> sortedSections = article.getSections().stream()
                .sorted(Comparator.comparingInt(Section::getArticlePosition))
                .collect(Collectors.toList());
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        article.setSections(sortedSections);
        model.addAttribute("article", article);
        model.addAttribute("username", username);
        return "articleEditMode";
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

    @PostMapping("/addNewSection")
    public String addNewSection(@RequestParam("articleId") long articleId,
                                @RequestParam("sectionTitle") String title,
                                final Model model) {
        Article article = articleService.addNewSections(articleId, title);
        model.addAttribute("article", article);
        return "redirect:/editArticle/" + articleId;
    }

    @PostMapping("/deleteSection")
    public String addNewSection(@RequestParam("articleId") long articleId,
                                @RequestParam("sectionId") long sectionId,
                                final Model model) {
        Article article = articleService.deleteSection(articleId, sectionId);
        model.addAttribute("article", article);
        return "redirect:/editArticle/" + articleId;
    }

    @GetMapping("/randomArticle")
    public String getRandomArticle(final Model model, HttpServletRequest request) {
        return "";
    }
}
