package com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.reader;

import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.entity.LinuxWallpaper;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class LinuxWallpaperReader implements ItemReader<LinuxWallpaper> {
    private int count = 0;

    @Override
    public LinuxWallpaper read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        LinuxWallpaper linuxWallpaper = new LinuxWallpaper();
        linuxWallpaper.setTitle("title");
        linuxWallpaper.setSrc("src");

        count++;
        if(count==3){
            return null;
        }

        return linuxWallpaper;
    }
}
