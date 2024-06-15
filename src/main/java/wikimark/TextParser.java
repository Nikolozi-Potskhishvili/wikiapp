package wikimark;

import com.freewiki.wikiapp.model.WikiHyperLink;

import java.util.ArrayList;
import java.util.List;

public class TextParser {

    public TextParser() {

    }


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

    public static String getParsedText(String content) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < content.length(); i++) {
            if(content.charAt(i) == '[') {
                int k = i + 1;
                if(k < content.length()) {
                    char cur = content.charAt(k);
                    switch (cur) {
                        case '[':
                            if(content.charAt(k) == '[') {
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
                            } else {
                                result.append("[");
                            }
                    }
                }
            } else {
                result.append(content.charAt(i));
            }
        }
        return result.toString();
    }
}
