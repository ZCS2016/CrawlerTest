package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.processor;

import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.crawler.GameWallpaperCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import com.example.CrawlerTest.crawler.util.io.download.MultiThreadPictureDownloadService;
import com.example.CrawlerTest.crawler.util.io.download.entity.PictureDownloadTask;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;

public class GameWallpaperDownloadProcessor implements ItemProcessor<GameWallpaper,GameWallpaper> {

    @Autowired
    MultiThreadPictureDownloadService multiThreadPictureDownloadService;

    @Value("${crawler.downloadDir}")
    private String downloadDir;

    @Override
    public GameWallpaper process(GameWallpaper gameWallpaper) throws Exception {
        //Download HD img
        PictureDownloadTask pictureDownloadTask = new PictureDownloadTask();
        pictureDownloadTask.setUrlStr(gameWallpaper.getImg());
        pictureDownloadTask.setFileName(gameWallpaper.getHash()+".jpg");
        pictureDownloadTask.setLocalDir(downloadDir);
        multiThreadPictureDownloadService.addPictureDownloadTask(pictureDownloadTask);

        return gameWallpaper;
    }
}
