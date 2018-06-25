package com.example.CrawlerTest.api.wallpaperswide.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.WallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Wallpaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/WallpapersWide/Categories")
@CrossOrigin(origins = "*")
public class CategoriesApiController {
    @Autowired
    CategoriesMapper categoriesMapper;

    @Autowired
    WallpaperMapper wallpaperMapper;

    @RequestMapping("/all")
    public List<Categories> getAll(){
        List<Categories> categories = categoriesMapper.selectList(new EntityWrapper<Categories>());
        return categories;
    }

    @RequestMapping("/level/{level}/{parentId}")
    public List<Categories> getLevel(@PathVariable Integer level, @PathVariable Integer parentId){
        EntityWrapper<Categories> categoriesEntityWrapper = new EntityWrapper<>();
        if(level != null) {
            categoriesEntityWrapper.eq("level",level);
        }
        if(parentId != null){
            categoriesEntityWrapper.eq("parent_id",parentId);
        }
        List<Categories> categories = categoriesMapper.selectList(categoriesEntityWrapper);
        return categories;
    }

    @RequestMapping("/{categoriesId}")
    public Categories getById(@PathVariable Integer categoriesId){
        Categories categories = categoriesMapper.selectById(categoriesId);
        return categories;
    }

    @RequestMapping("/{categoriesId}/page")
    public List<Wallpaper> getPage(@PathVariable Integer categoriesId, int current, int size){
        List<Wallpaper> wallpaperList = wallpaperMapper.selectPage(
                new Page<Wallpaper>(current,size),
                new EntityWrapper<Wallpaper>().eq("categories_id",categoriesId).orderBy("page").orderBy("id")
        );
        return wallpaperList;
    }

}
