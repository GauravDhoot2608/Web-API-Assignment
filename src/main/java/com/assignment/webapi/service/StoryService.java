package com.assignment.webapi.service;

import com.assignment.webapi.model.Story;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoryService {


    public List<Story> getTimeStories(){
        List<Story> latestStories = new ArrayList<>();

        try {
            Document document = Jsoup.connect("https://time.com").get();
            Elements elements = document.select("div.partial.latest-stories li.latest-stories__item");

            for (Element element : elements) {
                String title = element.select("h3.latest-stories__item-headline").text();
                String link = element.select("a").attr("href");
                latestStories.add(new Story(title, link));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return latestStories;
    }
}
