package wikimark;

import com.freewiki.wikiapp.model.WikiHyperLink;

import java.util.ArrayList;
import java.util.List;

public class TextParser {

    public TextParser() {

    }

    //for media content [{placement|mediaType|text|URL|}] ex [{left|image|photo of object|URL}]


    /*
        links in the text are represented [[link text|URL]]
     */
    public static List<WikiHyperLink> extractLinks(String content) {
        List<WikiHyperLink> links = new ArrayList<>();
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
                WikiHyperLink wikiHyperLink = new WikiHyperLink();
                wikiHyperLink.setLinkText(linkText.toString());
                wikiHyperLink.setLinkUrl(linkUrl.toString());
                links.add(wikiHyperLink);
                i = k;
            } else {
                i++;
            }
        }
        return links;
    }

    // [

    public static String getParsedText(String content) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < content.length(); i++) {
            if(content.charAt(i) == '[') {
                int k = i + 1;
                if(k < content.length()) {
                    char cur = content.charAt(k);
                    switch (cur) {
                        case '[':
                                k++;
                                StringBuilder htmlHref = new StringBuilder();
                                htmlHref.append("<a href=\"");
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
                                if (k + 1 < content.length() && content.charAt(k) == ']' && content.charAt(k + 1) == ']') {
                                    htmlHref.append(linkUrl).append("\">").append(linkText).append("</a>");
                                    result.append(htmlHref);
                                    k += 2;
                                    i = k - 1;
                                }
                                break;
                        case '{':
                            k++;
                            StringBuilder placement = new StringBuilder();
                            StringBuilder mediaType = new StringBuilder();
                            StringBuilder text = new StringBuilder();
                            StringBuilder url = new StringBuilder();
                            // Extract placement
                            while (k < content.length() && content.charAt(k) != '|') {
                                placement.append(content.charAt(k));
                                k++;
                            }
                            k++;
                            // Extract mediaType
                            while (k < content.length() && content.charAt(k) != '|') {
                                mediaType.append(content.charAt(k));
                                k++;
                            }
                            k++;
                            // Extract text
                            while (k < content.length() && content.charAt(k) != '|') {
                                text.append(content.charAt(k));
                                k++;
                            }
                            k++;
                            // Extract URL
                            while (k < content.length() && !(content.charAt(k) == '}' && k + 1 < content.length() && content.charAt(k + 1) == ']')) {
                                url.append(content.charAt(k));
                                k++;
                            }

                            if (k + 1 < content.length() && content.charAt(k) == '}' && content.charAt(k + 1) == ']') {
                                String htmlElement = generateMediaHtmlElement(placement.toString(), mediaType.toString(), text.toString(), url.toString());
                                result.append(htmlElement);
                                k += 2;
                                i = k - 1;
                            } else {
                                result.append("[{").append(placement).append("|").append(mediaType).append("|").append(text).append("|").append(url).append("}");
                            }
                            break;
                        default:
                            result.append("[");
                            break;
                    }
                }
            } else {
                result.append(content.charAt(i));
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
