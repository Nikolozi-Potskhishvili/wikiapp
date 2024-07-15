package com.freewiki.wikiapp.requests;

public class UpvoteRequest {
    private boolean isUpvote;

    public boolean isUpvote() {
        return isUpvote;
    }

    public void setUpvote(boolean upvote) {
        isUpvote = upvote;
    }
}
