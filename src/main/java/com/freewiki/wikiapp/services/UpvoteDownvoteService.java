package com.freewiki.wikiapp.services;

import com.freewiki.wikiapp.model.Article;
import com.freewiki.wikiapp.model.UpvoteDownvote;
import com.freewiki.wikiapp.repository.UpvoteDownvoteRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UpvoteDownvoteService {
    private final UpvoteDownvoteRepository upvoteDownvoteRepository;

    public UpvoteDownvoteService(UpvoteDownvoteRepository upvoteDownvoteRepository) {
        this.upvoteDownvoteRepository = upvoteDownvoteRepository;
    }

    public Map<Article, Integer> getArticleUpvoteMap(List<Article> articles) {
        List<UpvoteDownvote> upvoteDownvotes = upvoteDownvoteRepository.findAllByArticles(articles);
        return upvoteListToMap(upvoteDownvotes);
    }

    public UpvoteDownvote setUpvoteDownvote(UpvoteDownvote upvoteDownvote) {
        return upvoteDownvoteRepository.save(upvoteDownvote);
    }

    private Map<Article, Integer> upvoteListToMap(List<UpvoteDownvote> upvoteDownvotes) {
        Map<Article, Integer> articleUpvoteMap = new HashMap<>();
        for(UpvoteDownvote upvoteDownvote : upvoteDownvotes) {
            Article article = upvoteDownvote.getArticle();
            boolean upvote = upvoteDownvote.isUpvote();
            articleUpvoteMap.merge(article, upvote ? 1 : -1, Integer::sum);
        }
        return articleUpvoteMap;
    }
}
