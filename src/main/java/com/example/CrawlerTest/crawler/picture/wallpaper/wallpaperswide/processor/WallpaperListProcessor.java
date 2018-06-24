package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.processor;

import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler.WallpaperListCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Wallpaper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WallpaperListProcessor implements ItemProcessor<Categories,Categories> {
    @Autowired
    WallpaperListCrawler wallpaperListCrawler;

    @Override
    public Categories process(Categories rootCategories) throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t process: \t"+rootCategories.getId()+"\t page: \t"+rootCategories.getCurrent());
        List<Wallpaper> childrenWallpapers = wallpaperListCrawler.getWallpaperList(rootCategories);
        rootCategories.setChildrenWallpapers(childrenWallpapers);
        return rootCategories;
    }

}
