package problems.t1242;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private HtmlParser htmlParser;
    private String hostname;
    private Set<String> resSet;
    private Map<String, List<String>> cache;

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        this.htmlParser = htmlParser;
        this.hostname = getHostname(startUrl);
        this.resSet = new ConcurrentSkipListSet<>();
        this.cache = new ConcurrentHashMap<>();
        dfs(startUrl);
        return this.resSet.stream().sorted().toList();
    }

    private void dfs(String url) {
        resSet.add(url);
        if (!cache.containsKey(url)) {
            cache.put(url, htmlParser.getUrls(url));
        }
        cache.get(url).parallelStream()
                .filter(u -> !cache.containsKey(u))
                .filter(u -> getHostname(u).equals(hostname))
                .forEach(this::dfs);
    }

    private String getHostname(String url) {
        Pattern pattern = Pattern.compile("https?://([\\d\\w.-]+)/?.*");
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            return matcher.group(1);
        } else return "";
    }

    protected interface HtmlParser {
        List<String> getUrls(String url);
    }
}
