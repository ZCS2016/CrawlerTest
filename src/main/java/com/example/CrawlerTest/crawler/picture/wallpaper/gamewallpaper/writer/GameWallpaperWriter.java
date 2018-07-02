package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.writer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import com.example.CrawlerTest.crawler.util.io.download.MultiThreadPictureDownloadService;
import com.example.CrawlerTest.crawler.util.io.download.entity.PictureDownloadTask;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.List;

public class GameWallpaperWriter implements ItemWriter<GameWallpaperCategories> {
    @Autowired
    GameWallpaperCategoriesMapper gameWallpaperCategoriesMapper;

    @Autowired
    GameWallpaperMapper gameWallpaperMapper;

    @Override
    public void write(List<? extends GameWallpaperCategories> list) throws Exception {

        for(GameWallpaperCategories gameWallpaperCategories:list){
            for(GameWallpaper gameWallpaper:gameWallpaperCategories.getChildrenWallpapers()){
                try {
                    Integer count = gameWallpaperMapper.selectCount(new EntityWrapper<GameWallpaper>().eq("hash",gameWallpaper.getHash()));
                    if(count==0) {
                        gameWallpaperMapper.insert(gameWallpaper);
                    }else{
                        System.out.println("GameWallpaper exists! " + gameWallpaper.getTitle());
                    }
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }

            //Update GameWallpaperCategories
            gameWallpaperCategories.setCount(gameWallpaperCategories.getChildrenWallpapers().size());
            if(gameWallpaperCategories.getChildrenWallpapers().size()>0) {
                gameWallpaperCategories.setImg(gameWallpaperCategories.getChildrenWallpapers().get(0).getImg());
            }
            gameWallpaperCategoriesMapper.updateById(gameWallpaperCategories);
        }
    }

}
