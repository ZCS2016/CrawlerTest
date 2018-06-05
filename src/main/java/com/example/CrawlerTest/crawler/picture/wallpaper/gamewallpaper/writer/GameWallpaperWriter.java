package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.writer;

import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.util.io.download.PictureDownloadService;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class GameWallpaperWriter implements ItemWriter<GameWallpaper> {

    @Override
    public void write(List<? extends GameWallpaper> list) throws Exception {
        for(GameWallpaper gameWallpaper:list){
            String src = gameWallpaper.getSrc();
            String title = gameWallpaper.getTitle();
            String fileType = src.substring(src.lastIndexOf("."));
            title += fileType;
            PictureDownloadService.downloadPicture(src,title,"img/game");
        }
    }

}
