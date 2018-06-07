package com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.processor;

import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.dao.LinuxWallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.entity.LinuxWallpaper;
import com.example.CrawlerTest.crawler.util.codec.SHAUtil;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class LinuxWallpaperProcessor implements ItemProcessor<LinuxWallpaper,LinuxWallpaper> {
    @Autowired
    LinuxWallpaperMapper linuxWallpaperMapper;

    @Override
    public LinuxWallpaper process(LinuxWallpaper linuxWallpaper) throws Exception {

        System.out.println("--------------------------------------------------------------");
        System.out.println(linuxWallpaper.getTitle()+"\t"+linuxWallpaper.getSrc()+"\t"+linuxWallpaper.getHash());
        System.out.println("--------------------------------------------------------------");

        try {
            linuxWallpaperMapper.insert(linuxWallpaper);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return linuxWallpaper;
    }
}
