package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.reader;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler.CategoriesListCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.web.dao.CrawlerJobMapper;
import com.example.CrawlerTest.web.entity.CrawlerJob;
import com.example.CrawlerTest.web.service.CrawlerJobService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoriesListReader implements ItemReader<Categories> {

    @Autowired
    private CrawlerJobService crawlerJobService;

    @Override
    public Categories read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Categories categories = crawlerJobService.readRootCategories("categoriesListJob");
        System.out.println(Thread.currentThread().getName()+"/t read: \t"+(categories==null?null:categories.getId()));
        return categories;
    }
}
