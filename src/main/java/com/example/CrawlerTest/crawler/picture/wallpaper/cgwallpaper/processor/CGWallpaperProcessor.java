package com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.processor;

import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.crawler.CGWallpaperCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaperCategories;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class CGWallpaperProcessor implements ItemProcessor<CGWallpaperCategories,CGWallpaperCategories> {

    @Autowired
    CGWallpaperCrawler cgWallpaperCrawler;

    @Override
    public CGWallpaperCategories process(CGWallpaperCategories cgWallpaperCategories) throws Exception {
        cgWallpaperCategories.setChildrenWallpapers(cgWallpaperCrawler.getCGWallpaperList(cgWallpaperCategories));
        return cgWallpaperCategories;
    }
}
