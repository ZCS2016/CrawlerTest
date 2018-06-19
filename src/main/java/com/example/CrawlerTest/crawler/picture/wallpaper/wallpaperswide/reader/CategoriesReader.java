package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.reader;

import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler.CategoriesCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoriesReader implements ItemReader<Categories> {

    @Autowired
    CategoriesCrawler categoriesCrawler;

    private int count = 0;
    private List<Categories> categoriesList = new ArrayList<>();

    @Override
    public Categories read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(categoriesList.isEmpty()){
            categoriesList.addAll(categoriesCrawler.getCategoriesList());
        }

        if(!categoriesList.isEmpty()&&count<categoriesList.size()){
            return categoriesList.get(count++);
        }else{
            count = 0;
            categoriesList.clear();
            return null;
        }
    }
}
