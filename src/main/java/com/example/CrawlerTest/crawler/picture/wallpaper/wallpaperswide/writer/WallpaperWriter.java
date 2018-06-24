package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.writer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.WallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Wallpaper;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WallpaperWriter implements ItemWriter<Categories> {
    @Autowired
    WallpaperMapper wallpaperMapper;

    @Override
    public void write(List<? extends Categories> categoriesList) throws Exception {
        for (Categories categories : categoriesList) {
            System.out.println(Thread.currentThread().getName()+"\t write: \t"+categories.getId()+"\t page: \t"+categories.getCurrent());
            for (Wallpaper childrenWallpaper : categories.getChildrenWallpapers()) {
                try {
                    Integer count = wallpaperMapper.selectCount(new EntityWrapper<Wallpaper>().eq("hash", childrenWallpaper.getHash()));
                    if (count == 0) {
                        wallpaperMapper.insert(childrenWallpaper);
                    } else {
                        System.out.println("Wallpaperswide_Wallpaper" + childrenWallpaper.getTitle() + "exists!");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

}
