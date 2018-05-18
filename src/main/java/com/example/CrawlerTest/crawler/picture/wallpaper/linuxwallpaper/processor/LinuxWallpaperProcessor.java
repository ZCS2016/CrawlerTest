package com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.processor;

import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.entity.LinuxWallpaper;
import org.springframework.batch.item.ItemProcessor;

public class LinuxWallpaperProcessor implements ItemProcessor<LinuxWallpaper,LinuxWallpaper> {
    @Override
    public LinuxWallpaper process(LinuxWallpaper linuxWallpaper) throws Exception {
        System.out.println("--------------------------------------------------------------");
        System.out.println(linuxWallpaper.getTitle()+"\t"+linuxWallpaper.getSrc());
        System.out.println("--------------------------------------------------------------");
        return linuxWallpaper;
    }
}
