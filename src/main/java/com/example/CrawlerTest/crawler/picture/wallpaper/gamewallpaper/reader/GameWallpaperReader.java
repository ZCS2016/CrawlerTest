package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.reader;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.crawler.GameWallpaperCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GameWallpaperReader implements ItemReader<GameWallpaperCategories> {
    @Autowired
    GameWallpaperCategoriesMapper gameWallpaperCategoriesMapper;

    private int count = 0;
    private List<GameWallpaperCategories> gameWallpaperCategoriesList = new ArrayList<>();

    @Override
    public GameWallpaperCategories read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(gameWallpaperCategoriesList.isEmpty()){
            gameWallpaperCategoriesList.addAll(gameWallpaperCategoriesMapper.selectList(
                    new EntityWrapper<GameWallpaperCategories>()
            ));
        }

        if(!gameWallpaperCategoriesList.isEmpty()&&count<gameWallpaperCategoriesList.size()){
            System.out.println("Process " + (count+1) + " : " + gameWallpaperCategoriesList.get(count).getTitle());
            return gameWallpaperCategoriesList.get(count++);
        }else{
            count = 0;
            gameWallpaperCategoriesList.clear();
            return null;
        }
    }

}
