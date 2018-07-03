package com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.processor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.dao.CGWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaperCategories;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class CGWallpaperCategoriesProcessor implements ItemProcessor<CGWallpaperCategories,CGWallpaperCategories> {
    @Autowired
    CGWallpaperCategoriesMapper cgWallpaperCategoriesMapper;

    @Override
    public CGWallpaperCategories process(CGWallpaperCategories cgWallpaperCategories) throws Exception {

        System.out.println("--------------------------------------------------------------");
        System.out.println(cgWallpaperCategories.getTitle()+"\t"+cgWallpaperCategories.getSrc()+"\t"+cgWallpaperCategories.getHash());
        System.out.println("--------------------------------------------------------------");

        try {
            Integer count = cgWallpaperCategoriesMapper.selectCount(new EntityWrapper<CGWallpaperCategories>().eq("hash",cgWallpaperCategories.getHash()));
            if(count==0) {
                cgWallpaperCategoriesMapper.insert(cgWallpaperCategories);
            }else{
                System.out.println("CGWallpaperCategories exists! " + cgWallpaperCategories.getTitle());
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return cgWallpaperCategories;
    }


}
