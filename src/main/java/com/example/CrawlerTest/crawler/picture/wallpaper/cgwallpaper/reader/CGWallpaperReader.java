package com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.reader;

import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaperCategories;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.service.CGWallpaperJobService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

public class CGWallpaperReader implements ItemReader<CGWallpaperCategories> {
    @Autowired
    CGWallpaperJobService cgWallpaperJobService;

    @Override
    public CGWallpaperCategories read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        CGWallpaperCategories cgWallpaperCategories = cgWallpaperJobService.readCGWallpaper();
        if(cgWallpaperCategories != null) {
            System.out.println(cgWallpaperCategories.getId() + "\t" + cgWallpaperCategories.getTitle());
        }
        return cgWallpaperCategories;
    }

}
