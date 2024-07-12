package com.freewiki.wikiapp.wikimark;


import com.freewiki.wikiapp.model.WikiHyperlink;

import java.util.ArrayList;
import java.util.List;

public class TextParser {

    public TextParser() {

    }

    //for media content [{placement|mediaType|text|URL|}] ex [{left|image|photo of object|URL}]


    /*
        links in the text are represented [[link text|URL]]
     */
    public static List<WikiHyperlink> extractLinks(String content) {
        List<WikiHyperlink> links = new ArrayList<>();
        int i = 0;
        while (i < content.length()) {
            if (content.charAt(i) == '[' && i + 1 < content.length() && content.charAt(i + 1) == '[') {
                int k = i + 2;
                StringBuilder linkText = new StringBuilder();
                StringBuilder linkUrl = new StringBuilder();
                while (k < content.length() && content.charAt(k) != '|') {
                    linkText.append(content.charAt(k));
                    k++;
                }
                k++;
                while (k < content.length() && !(content.charAt(k) == ']' && k + 1 < content.length() && content.charAt(k + 1) == ']')) {
                    linkUrl.append(content.charAt(k));
                    k++;
                }
                k += 2;
                WikiHyperlink wikiHyperLink = new WikiHyperlink();
                wikiHyperLink.setText(linkText.toString());
                wikiHyperLink.setUrl(linkUrl.toString());
                links.add(wikiHyperLink);
                i = k;
            } else {
                i++;
            }
        }
        return links;
    }

    // [p] content [/p]

    public static String getParsedText(String content) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '[') {
                int k = i + 1;
                if (k < content.length()) {
                    char cur = content.charAt(k);
                    if (cur == 'p') {
                        k++;
                        if (k < content.length() && content.charAt(k) == ']') {
                            // Start of paragraph tag found
                            StringBuilder paragraphContent = new StringBuilder();
                            k++;
                            while (k < content.length()) {
                                if(content.charAt(k) == '[' &&  k + 1 < content.length() && content.charAt(k + 1) == 'p') {
                                    break;
                                }
                                paragraphContent.append(content.charAt(k));
                                k++;
                            }
                            result.append("<p>").append(parseContent(paragraphContent.toString())).append("</p>");
                            i = k + 4;
                        }
                    }
                }
            } else {
                i++;
            }
        }
        return result.toString();
    }

    private static String parseContent(String content) {
        StringBuilder result = new StringBuilder();
        System.out.println(content);
        int i = 0;
        while (i < content.length()) {
            if (content.charAt(i) == '[') {
                int k = i + 1;
                if (k < content.length()) {
                    char cur = content.charAt(k);
                    switch (cur) {
                        case '[':
                            // Handle hyperlinks
                            k++;
                            StringBuilder linkText = new StringBuilder();
                            StringBuilder linkUrl = new StringBuilder();
                            while (k < content.length() && content.charAt(k) != '|') {
                                linkText.append(content.charAt(k));
                                k++;
                            }
                            k++;
                            while (k < content.length() && content.charAt(k) != ']') {
                                linkUrl.append(content.charAt(k));
                                k++;
                            }
                            if (k < content.length() && content.charAt(k) == ']') {
                                result.append("<a href=\"").append(linkUrl).append("\">").append(linkText).append("</a>");
                                i = k + 2;
                            }
                            break;
                        case '{':
                            // Handle media elements
                            k++;
                            StringBuilder mediaPlacement = new StringBuilder();
                            StringBuilder mediaType = new StringBuilder();
                            StringBuilder mediaText = new StringBuilder();
                            StringBuilder mediaUrl = new StringBuilder();
                            while (k < content.length() && content.charAt(k) != '|') {
                                mediaPlacement.append(content.charAt(k));
                                k++;
                            }
                            k++;
                            while (k < content.length() && content.charAt(k) != '|') {
                                mediaType.append(content.charAt(k));
                                k++;
                            }
                            k++;
                            while (k < content.length() && content.charAt(k) != '|') {
                                mediaText.append(content.charAt(k));
                                k++;
                            }
                            k++;
                            while (k < content.length() && content.charAt(k) != '}') {
                                mediaUrl.append(content.charAt(k));
                                k++;
                            }
                            if (k < content.length() && content.charAt(k) == '}') {
                                result.append("<").append(mediaType).append(" src=\"").append(mediaUrl).append("\" alt=\"").append(mediaText).append("\" class=\"").append(mediaPlacement).append("\">");
                                i = k + 2;
                            }
                            break;
                        default:
                            result.append("[");
                            i++;
                            break;
                    }
                }
            } else {
                result.append(content.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    private static String generateParagraphHtmlElement(String text) {
        return "<p class='paragraph-part'>" + text + "</p>";
    }

    private static String generateMediaHtmlElement(String placement, String mediaType, String text, String url) {
        return switch (mediaType) {
            case "image" ->
                    String.format("<div ><img class='custom-image' src='%s' alt='%s'></div>", url, text);
            case "video" ->
                    String.format("<div style='float: %s;'><video controls><source src='%s' type='video/mp4'>%s</video></div>", placement, url, text);
            default -> String.format("<div style='text-align: %s;'>%s</div>", placement, text);
        };
    }

}
