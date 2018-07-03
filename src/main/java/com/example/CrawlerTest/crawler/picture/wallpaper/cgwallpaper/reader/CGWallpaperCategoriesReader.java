package com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.reader;

import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.crawler.CGWallpaperCategoriesCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaperCategories;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CGWallpaperCategoriesReader implements ItemReader<CGWallpaperCategories> {
    @Autowired
    private CGWallpaperCategoriesCrawler cgWallpaperCategoriesCrawler;

    private int count = 0;
    private List<CGWallpaperCategories> cgWallpaperCategories = new ArrayList<>();

    @Override
    public CGWallpaperCategories read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(cgWallpaperCategories.isEmpty()){
            cgWallpaperCategories.addAll(cgWallpaperCategoriesCrawler.getCGWallpaperCategoriesList("https://www.cgwallpapers.com/index.php?page=directory"));
        }

        if(!cgWallpaperCategories.isEmpty()&&count< cgWallpaperCategories.size()){
            return cgWallpaperCategories.get(count++);
        }else{
            count = 0;
            cgWallpaperCategories.clear();
            return null;
        }
    }

}
