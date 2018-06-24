package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.processor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler.CategoriesListImgCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriesListImgProcessor implements ItemProcessor<Categories,Categories> {

    @Autowired
    CategoriesListImgCrawler categoriesListImgCrawler;

    @Override
    public Categories process(Categories rootCategories) throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t process: \t"+rootCategories.getId());
        categoriesListImgCrawler.getCategoriesListImg(rootCategories);
        return rootCategories;
    }

}
