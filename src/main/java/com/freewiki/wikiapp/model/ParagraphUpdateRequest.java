package com.freewiki.wikiapp.model;

public class ParagraphUpdateRequest {

    private Long paragraphId;

    private String content;

    public Long getParagraphId() {
        return paragraphId;
    }

    public void setParagraphId(Long paragraphId) {
        this.paragraphId = paragraphId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
