package com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.reader;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.dao.CGWallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaper;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CGWallpaperDownloadReader implements ItemReader<CGWallpaper> {
    @Autowired
    CGWallpaperMapper cgWallpaperMapper;

    private int count = 0;
    private List<CGWallpaper> cgWallpapers = new ArrayList<>();

    @Override
    public CGWallpaper read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(cgWallpapers.isEmpty()){
            cgWallpapers.addAll(cgWallpaperMapper.selectList(
                    new EntityWrapper<CGWallpaper>()
            ));
        }

        if(!cgWallpapers.isEmpty()&&count< cgWallpapers.size()){
            System.out.println("Process " + (count+1) + " : " + cgWallpapers.get(count).getTitle());
            return cgWallpapers.get(count++);
        }else{
            count = 0;
            cgWallpapers.clear();
            return null;
        }
    }

}
