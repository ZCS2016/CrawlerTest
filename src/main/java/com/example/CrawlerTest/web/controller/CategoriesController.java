package com.example.CrawlerTest.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Crawler/WallpapersWide/Categories")
@CrossOrigin(origins = "*")
public class CategoriesController {

    @Autowired
    CategoriesMapper categoriesMapper;

    @RequestMapping("/all")
    public List<Categories> getAll(){
        List<Categories> categories = categoriesMapper.selectList(new EntityWrapper<Categories>());
        return categories;
    }

    @RequestMapping("/level/{level}/{parentId}")
    public List<Categories> getLevel(@PathVariable Integer level,@PathVariable Integer parentId){
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

}
