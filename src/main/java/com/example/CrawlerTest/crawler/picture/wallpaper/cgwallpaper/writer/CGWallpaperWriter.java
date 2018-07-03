package com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.writer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.dao.CGWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.dao.CGWallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaperCategories;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CGWallpaperWriter implements ItemWriter<CGWallpaperCategories> {
    @Autowired
    CGWallpaperCategoriesMapper cgWallpaperCategoriesMapper;

    @Autowired
    CGWallpaperMapper cgWallpaperMapper;

    @Override
    public void write(List<? extends CGWallpaperCategories> list) throws Exception {

        for(CGWallpaperCategories cgWallpaperCategories:list){
            for(CGWallpaper cgWallpaper:cgWallpaperCategories.getChildrenWallpapers()){
                try {
                    Integer count = cgWallpaperMapper.selectCount(new EntityWrapper<CGWallpaper>().eq("hash",cgWallpaper.getHash()));
                    if(count==0) {
                        cgWallpaperMapper.insert(cgWallpaper);
                    }else{
                        System.out.println("CGWallpaper exists! " + cgWallpaper.getTitle());
                    }
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }

            //Update CGWallpaperCategories
            cgWallpaperCategories.setCount(cgWallpaperCategories.getChildrenWallpapers().size());
            if(cgWallpaperCategories.getChildrenWallpapers().size()>0) {
                cgWallpaperCategories.setImg(cgWallpaperCategories.getChildrenWallpapers().get(0).getImg());
                cgWallpaperCategories.setImgHash(cgWallpaperCategories.getChildrenWallpapers().get(0).getHash());
            }
            cgWallpaperCategoriesMapper.updateById(cgWallpaperCategories);
        }
    }

}
