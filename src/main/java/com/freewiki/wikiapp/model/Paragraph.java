package com.freewiki.wikiapp.model;

import jakarta.persistence.*;
import com.freewiki.wikiapp.wikimark.TextParser;

@Entity
@Table(name = "paragraphs")
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;


    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(nullable = false)
    private int position;

    public String getParsedText() {
        return TextParser.getParsedText(content);
    }

    public String getTitle() {
        return title;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }


}
