package com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.processor;

import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaper;
import com.example.CrawlerTest.crawler.util.io.download.MultiThreadPictureDownloadService;
import com.example.CrawlerTest.crawler.util.io.download.entity.PictureDownloadTask;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class CGWallpaperDownloadProcessor implements ItemProcessor<CGWallpaper,CGWallpaper> {

    @Autowired
    MultiThreadPictureDownloadService multiThreadPictureDownloadService;

    @Value("${crawler.downloadDir}")
    private String downloadDir;

    @Override
    public CGWallpaper process(CGWallpaper cgWallpaper) throws Exception {
        //Download HD img
        PictureDownloadTask pictureDownloadTask = new PictureDownloadTask();
        pictureDownloadTask.setUrlStr(cgWallpaper.getImg());
        pictureDownloadTask.setFileName(cgWallpaper.getHash()+".jpg");
        pictureDownloadTask.setLocalDir(downloadDir);
        multiThreadPictureDownloadService.addPictureDownloadTask(pictureDownloadTask);

        return cgWallpaper;
    }
}
