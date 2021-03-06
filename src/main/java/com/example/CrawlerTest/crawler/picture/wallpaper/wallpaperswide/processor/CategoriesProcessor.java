package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.processor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler.CategoriesCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoriesProcessor implements ItemProcessor<Categories,Categories> {

    @Autowired
    CategoriesCrawler categoriesCrawler;

    @Override
    public Categories process(Categories rootCategories) throws Exception {
        List<Categories> childrenCategories = categoriesCrawler.getCategoriesList(rootCategories);
        rootCategories.setChildrenCategories(childrenCategories);
        return rootCategories;
    }

}
