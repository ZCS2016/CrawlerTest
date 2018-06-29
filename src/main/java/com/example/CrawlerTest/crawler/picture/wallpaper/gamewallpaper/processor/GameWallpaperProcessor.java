package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.processor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.crawler.GameWallpaperCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import com.example.CrawlerTest.crawler.util.codec.SHAUtil;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class GameWallpaperProcessor implements ItemProcessor<GameWallpaperCategories,GameWallpaperCategories> {

    @Autowired
    GameWallpaperCrawler gameWallpaperCrawler;

    @Override
    public GameWallpaperCategories process(GameWallpaperCategories gameWallpaperCategories) throws Exception {
        gameWallpaperCategories.setChildrenWallpapers(gameWallpaperCrawler.getGameWallpaperList(gameWallpaperCategories));
        return gameWallpaperCategories;
    }
}
