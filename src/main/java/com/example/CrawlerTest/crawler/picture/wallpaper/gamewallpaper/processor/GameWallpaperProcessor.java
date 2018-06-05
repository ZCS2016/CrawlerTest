package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.processor;

import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.util.codec.SHAUtil;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class GameWallpaperProcessor implements ItemProcessor<GameWallpaper,GameWallpaper> {

    @Autowired
    GameWallpaperMapper gameWallpaperMapper;

    @Override
    public GameWallpaper process(GameWallpaper gameWallpaper) throws Exception {
        String id = SHAUtil.getSHA256Str(gameWallpaper.getSrc());
        gameWallpaper.setId(id);

        System.out.println("--------------------------------------------------------------");
        System.out.println(gameWallpaper.getId()+"\t"+gameWallpaper.getTitle()+"\t"+gameWallpaper.getSrc());
        System.out.println("--------------------------------------------------------------");

        try {
            gameWallpaperMapper.insert(gameWallpaper);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return gameWallpaper;
    }
}
