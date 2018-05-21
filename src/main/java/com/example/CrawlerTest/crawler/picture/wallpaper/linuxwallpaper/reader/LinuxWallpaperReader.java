package com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.reader;

import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.crawler.LinuxWallpaperCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.entity.LinuxWallpaper;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class LinuxWallpaperReader implements ItemReader<LinuxWallpaper> {

    @Autowired
    LinuxWallpaperCrawler linuxWallpaperCrawler;

    private int count = 0;
    private List<LinuxWallpaper> linuxWallpaperList = new ArrayList<>();

    @Override
    public LinuxWallpaper read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(linuxWallpaperList.isEmpty()){
            linuxWallpaperList.addAll(linuxWallpaperCrawler.getLinuxWallpaperList());
        }

        if(!linuxWallpaperList.isEmpty()&&count<linuxWallpaperList.size()){
            return linuxWallpaperList.get(count++);
        }else{
            return null;
        }
    }
}