package com.example.CrawlerTest.api.wallpaperswide.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/GameWallpaper")
@CrossOrigin(origins = "*")
public class GameWallpaperApiController {
    @Autowired
    GameWallpaperCategoriesMapper gameWallpaperCategoriesMapper;

    @RequestMapping("/Categories/all")
    public List<GameWallpaperCategories> getAll(){
        List<GameWallpaperCategories> categories = gameWallpaperCategoriesMapper.selectList(new EntityWrapper<GameWallpaperCategories>());
        return categories;
    }

}
