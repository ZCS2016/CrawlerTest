package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.reader;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.crawler.GameWallpaperCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.service.GameWallpaperJobService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GameWallpaperReader implements ItemReader<GameWallpaperCategories> {
    @Autowired
    GameWallpaperJobService gameWallpaperJobService;

    @Override
    public GameWallpaperCategories read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        GameWallpaperCategories gameWallpaperCategories = gameWallpaperJobService.readGameWallpaper();
        if(gameWallpaperCategories != null) {
            System.out.println(gameWallpaperCategories.getId() + "\t" + gameWallpaperCategories.getTitle());
        }
        return gameWallpaperCategories;
    }

}
