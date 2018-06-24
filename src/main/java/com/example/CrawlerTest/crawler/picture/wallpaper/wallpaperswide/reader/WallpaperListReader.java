package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.reader;

import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.web.service.CrawlerJobService;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

public class WallpaperListReader implements ItemReader<Categories> {

    @Autowired
    private CrawlerJobService crawlerJobService;

    @Override
    public Categories read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Categories rootCategories = crawlerJobService.readRootCategories("wallpaperListJob");
        System.out.println(Thread.currentThread().getName()+"/t read: \t"+(rootCategories==null?null:rootCategories.getId()+"\t page: \t"+rootCategories.getCurrent()));
        return rootCategories;
    }

}
