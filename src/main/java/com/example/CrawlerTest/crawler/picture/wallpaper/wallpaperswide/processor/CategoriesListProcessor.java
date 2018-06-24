package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.processor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler.CategoriesListCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoriesListProcessor implements ItemProcessor<Categories,Categories> {

    @Autowired
    CategoriesListCrawler categoriesListCrawler;

    @Override
    public Categories process(Categories rootCategories) throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t process: \t"+rootCategories.getId());
        List<Categories> childrenCategories = categoriesListCrawler.getCategoriesList(rootCategories);
        rootCategories.setChildrenCategories(childrenCategories);
        return rootCategories;
    }

}
