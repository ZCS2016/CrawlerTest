package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.processor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.crawler.GameWallpaperCategoriesCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GameWallpaperCategoriesProcessor implements ItemProcessor<GameWallpaperCategories,GameWallpaperCategories> {
    @Autowired
    GameWallpaperCategoriesMapper gameWallpaperCategoriesMapper;

    @Override
    public GameWallpaperCategories process(GameWallpaperCategories gameWallpaperCategories) throws Exception {

        System.out.println("--------------------------------------------------------------");
        System.out.println(gameWallpaperCategories.getTitle()+"\t"+gameWallpaperCategories.getSrc()+"\t"+gameWallpaperCategories.getHash());
        System.out.println("--------------------------------------------------------------");

        try {
            Integer count = gameWallpaperCategoriesMapper.selectCount(new EntityWrapper<GameWallpaperCategories>().eq("hash",gameWallpaperCategories.getHash()));
            if(count==0) {
                gameWallpaperCategoriesMapper.insert(gameWallpaperCategories);
            }else{
                System.out.println("GameWallpaperCategories exists! " + gameWallpaperCategories.getTitle());
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return gameWallpaperCategories;
    }


}
