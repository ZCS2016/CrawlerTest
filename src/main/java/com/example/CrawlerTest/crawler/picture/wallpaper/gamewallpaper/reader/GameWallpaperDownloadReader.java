package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.reader;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GameWallpaperDownloadReader implements ItemReader<GameWallpaper> {
    @Autowired
    GameWallpaperMapper gameWallpaperMapper;

    private int count = 0;
    private List<GameWallpaper> gameWallpaperList = new ArrayList<>();

    @Override
    public GameWallpaper read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(gameWallpaperList.isEmpty()){
            gameWallpaperList.addAll(gameWallpaperMapper.selectList(
                    new EntityWrapper<GameWallpaper>()
            ));
        }

        if(!gameWallpaperList.isEmpty()&&count<gameWallpaperList.size()){
            System.out.println("Process " + (count+1) + " : " + gameWallpaperList.get(count).getTitle());
            return gameWallpaperList.get(count++);
        }else{
            count = 0;
            gameWallpaperList.clear();
            return null;
        }
    }

}
