package com.freewiki.wikiapp.controllers;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.Paragraph;
import com.freewiki.wikiapp.model.User;
import com.freewiki.wikiapp.services.ArticleService;
import com.freewiki.wikiapp.services.ParagraphService;
import com.freewiki.wikiapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ArticleController {
    private final ArticleService articleService;
    private final ParagraphService paragraphService;
    private final UserService userService;

    @Autowired
    public ArticleController(ArticleService articleService, ParagraphService paragraphService, UserService userService) {
        this.articleService = articleService;
        this.paragraphService = paragraphService;
        this.userService = userService;
    }

    @GetMapping("/searchForArticle")
    public String searchArticle(@RequestParam String title, final Model model) {
        ArrayList<Article> articles = articleService.findArticlesByTitle(title);
        model.addAttribute("articles", articles);
        model.addAttribute("title", title);
        return "searchResults";
    }

    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable("id") long id, final Model model) {
        Article article = articleService.findArticleById(id);
        List<Paragraph> sortedParagraphs = article.getParagraphs().stream()
                .sorted(Comparator.comparingInt(Paragraph::getPosition))
                .collect(Collectors.toList());
        article.setParagraphs(sortedParagraphs);
        model.addAttribute("article", article);
        if(article != null) return "article";
        return null;
    }

    @PostMapping("/addNewParagraph")
    public String addNewParagraph(@RequestParam("articleId") long articleId,
                                  @RequestParam("paragraphType") String type,
                                  final Model model) {
        Article article = articleService.addNewParagraph(articleId, type);
        model.addAttribute("article", article);
        return "article";
    }

    @PostMapping("/changeArticleTitle")
    public String changeArticleName(@RequestParam("articleId") long articleId,
                                            @RequestParam("title") String title, final Model model) {
        Article article = articleService.changeTitle(articleId, title);
        model.addAttribute("article", article);
        return "article";
    }

    @PostMapping("/createNewArticle")
    public String createNewArticle(@RequestParam String title, @RequestParam Long user_id,
                                   final Model model) {
        if(false) {
            return "articleCreationError";
        } else {
            String[] paragraphTypes = {"Summary", "Body", "References"};
            User currnetUser = userService.getUserById(user_id);
            Article currentArticle = new Article();
            currentArticle.setAuthor(currnetUser);
            currentArticle.setTitle(title);
            for (int i = 1; i <= 3; i++) {
                Paragraph paragraph = new Paragraph();
                paragraph.setArticle(currentArticle);
                paragraph.setType(paragraphTypes[i - 1]);
                paragraph.setContent("");
                paragraph.setPosition(i);
                currentArticle.getParagraphs().add(paragraph);
            }
            articleService.saveNewArticle(currentArticle);
            model.addAttribute("article", currentArticle);
            return "article";
        }
    }
}
