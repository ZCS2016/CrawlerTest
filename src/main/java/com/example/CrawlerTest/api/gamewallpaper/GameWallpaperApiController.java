package com.example.CrawlerTest.api.gamewallpaper;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.dao.GameWallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/GameWallpaper")
@CrossOrigin(origins = "*")
public class GameWallpaperApiController {
    @Autowired
    GameWallpaperCategoriesMapper gameWallpaperCategoriesMapper;

    @Autowired
    GameWallpaperMapper gameWallpaperMapper;

    @RequestMapping("/Categories/all")
    public List<GameWallpaperCategories> getAll(){
        List<GameWallpaperCategories> categories = gameWallpaperCategoriesMapper.selectList(new EntityWrapper<GameWallpaperCategories>());
        return categories;
    }

    @RequestMapping("/Categories/{firstLetter}")
    public List<GameWallpaperCategories> getByFirstLetter(@PathVariable String firstLetter){
        List<GameWallpaperCategories> categories = gameWallpaperCategoriesMapper.selectList(
                new EntityWrapper<GameWallpaperCategories>().like("title",firstLetter,SqlLike.RIGHT)
        );
        return categories;
    }

    @RequestMapping("/GameWallpaper/{categoriesId}")
    public List<GameWallpaper> getGameWallpaperList(@PathVariable Integer categoriesId){
        List<GameWallpaper> gameWallpaperList = gameWallpaperMapper.selectList(
                new EntityWrapper<GameWallpaper>().eq("categories_id",categoriesId)
        );
        return gameWallpaperList;
    }

}
