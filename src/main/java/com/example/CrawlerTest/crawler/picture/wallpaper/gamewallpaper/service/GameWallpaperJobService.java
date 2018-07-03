package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class GameWallpaperJobService {
    @Autowired
    GameWallpaperCategoriesMapper gameWallpaperCategoriesMapper;

    private ArrayBlockingQueue<GameWallpaperCategories> gameWallpaperQ;

    public synchronized void startJob(){
        Wrapper<GameWallpaperCategories> categoriesWrapper = new EntityWrapper<GameWallpaperCategories>();
        categoriesWrapper.isNull("img");
        List<GameWallpaperCategories> gameWallpaperCategories = gameWallpaperCategoriesMapper.selectList(categoriesWrapper);
        if(gameWallpaperCategories.size() > 0){
            gameWallpaperQ = new ArrayBlockingQueue<>(gameWallpaperCategories.size());
            gameWallpaperQ.addAll(gameWallpaperCategories);
        }
    }

    public GameWallpaperCategories readGameWallpaper(){
        GameWallpaperCategories gameWallpaperCategories = null;
        if(gameWallpaperQ!=null) {
            gameWallpaperCategories = gameWallpaperQ.poll();
        }
        return gameWallpaperCategories;
    }

}
