package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.reader;

import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.crawler.GameWallpaperCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GameWallpaperReader implements ItemReader<GameWallpaper> {

    @Autowired
    GameWallpaperCrawler gameWallpaperCrawler;

    private int count = 0;
    private List<GameWallpaper> gameWallpaperList = new ArrayList<>();

    @Override
    public GameWallpaper read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(gameWallpaperList.isEmpty()){
            gameWallpaperList.addAll(gameWallpaperCrawler.getGameWallpaperList());
        }

        if(!gameWallpaperList.isEmpty()&&count<gameWallpaperList.size()){
            return gameWallpaperList.get(count++);
        }else{
            return null;
        }
    }

}
