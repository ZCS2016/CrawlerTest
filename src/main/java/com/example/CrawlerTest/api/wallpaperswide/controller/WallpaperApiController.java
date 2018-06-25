package com.example.CrawlerTest.api.wallpaperswide.controller;

import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.WallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Wallpaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/WallpapersWide/Wallpaper")
@CrossOrigin(origins = "*")
public class WallpaperApiController {
    @Autowired
    WallpaperMapper wallpaperMapper;

    @RequestMapping("/{wallpaperId}")
    public Wallpaper getById(@PathVariable Integer wallpaperId){
        Wallpaper wallpaper = wallpaperMapper.selectById(wallpaperId);
        return wallpaper;
    }

}
