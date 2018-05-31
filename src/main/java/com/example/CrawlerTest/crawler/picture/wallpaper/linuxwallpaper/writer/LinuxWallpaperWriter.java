package com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.writer;

import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.entity.LinuxWallpaper;
import com.example.CrawlerTest.crawler.util.io.download.PictureDownloadService;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class LinuxWallpaperWriter implements ItemWriter<LinuxWallpaper> {
    @Override
    public void write(List<? extends LinuxWallpaper> list) throws Exception {
        for(LinuxWallpaper linuxWallpaper:list){
            String src = linuxWallpaper.getSrc();
            String title = linuxWallpaper.getTitle();
            String fileType = src.substring(src.lastIndexOf("."));
            title += fileType;
            PictureDownloadService.downloadPicture(src,title,"img/linux");
        }
    }
}
