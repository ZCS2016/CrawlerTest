package com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.dao.CGWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaperCategories;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class CGWallpaperJobService {
    @Autowired
    CGWallpaperCategoriesMapper cgWallpaperCategoriesMapper;

    private ArrayBlockingQueue<CGWallpaperCategories> cgWallpaperQ;

    public synchronized void startJob(){
        Wrapper<CGWallpaperCategories> categoriesWrapper = new EntityWrapper<CGWallpaperCategories>();
        List<CGWallpaperCategories> cgWallpaperCategories = cgWallpaperCategoriesMapper.selectList(categoriesWrapper);
        if(cgWallpaperCategories.size() > 0){
            cgWallpaperQ = new ArrayBlockingQueue<>(cgWallpaperCategories.size());
            cgWallpaperQ.addAll(cgWallpaperCategories);
        }
    }

    public CGWallpaperCategories readCGWallpaper(){
        CGWallpaperCategories gameWallpaperCategories = null;
        if(cgWallpaperQ !=null) {
            gameWallpaperCategories = cgWallpaperQ.poll();
        }
        return gameWallpaperCategories;
    }

}
