package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.reader;

import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.crawler.GameWallpaperCategoriesCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GameWallpaperCategoriesReader implements ItemReader<GameWallpaperCategories> {
    @Autowired
    private GameWallpaperCategoriesCrawler gameWallpaperCategoriesCrawler;

    private int count = 0;
    private List<GameWallpaperCategories> gameWallpaperCategoriesList = new ArrayList<>();

    @Override
    public GameWallpaperCategories read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(gameWallpaperCategoriesList.isEmpty()){
            gameWallpaperCategoriesList.addAll(gameWallpaperCategoriesCrawler.getGameWallpaperCategoriesList("https://www.gamewallpapers.com/index.php?page=directory"));
        }

        if(!gameWallpaperCategoriesList.isEmpty()&&count<gameWallpaperCategoriesList.size()){
            return gameWallpaperCategoriesList.get(count++);
        }else{
            count = 0;
            gameWallpaperCategoriesList.clear();
            return null;
        }
    }

}
