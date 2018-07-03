package com.example.CrawlerTest.api.cgwallpaper;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.dao.CGWallpaperCategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.dao.CGWallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaperCategories;
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
@RequestMapping("/api/CGWallpaper")
@CrossOrigin(origins = "*")
public class CGWallpaperApiController {
    @Autowired
    CGWallpaperCategoriesMapper cgWallpaperCategoriesMapper;

    @Autowired
    CGWallpaperMapper cgWallpaperMapper;

    @RequestMapping("/Categories/all")
    public List<CGWallpaperCategories> getAll(){
        List<CGWallpaperCategories> categories = cgWallpaperCategoriesMapper.selectList(new EntityWrapper<CGWallpaperCategories>());
        return categories;
    }

    @RequestMapping("/Categories/{firstLetter}")
    public List<CGWallpaperCategories> getByFirstLetter(@PathVariable String firstLetter){
        List<CGWallpaperCategories> categories = cgWallpaperCategoriesMapper.selectList(
                new EntityWrapper<CGWallpaperCategories>().like("title",firstLetter,SqlLike.RIGHT)
        );
        return categories;
    }

    @RequestMapping("/CGWallpaper/{categoriesId}")
    public List<CGWallpaper> getCGWallpaperList(@PathVariable Integer categoriesId){
        List<CGWallpaper> cgWallpaperList = cgWallpaperMapper.selectList(
                new EntityWrapper<CGWallpaper>().eq("categories_id",categoriesId)
        );
        return cgWallpaperList;
    }

}
