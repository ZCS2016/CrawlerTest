package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.reader;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler.CategoriesListCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler.CategoriesListImgCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.web.dao.CrawlerJobMapper;
import com.example.CrawlerTest.web.entity.CrawlerJob;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoriesListImgReader implements ItemReader<Categories> {
    ////////////////////////////////////
    @Autowired
    private CrawlerJobMapper crawlerJobMapper;
    ////////////////////////////////////

    @Autowired
    CategoriesMapper categoriesMapper;

    private int count = 0;
    private List<Categories> categoriesList = new ArrayList<>();

    @Override
    public Categories read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        ////////////////////////////////////
        CrawlerJob categoriesJob = crawlerJobMapper.selectById("categoriesListImgJob");
        ////////////////////////////////////

        if(categoriesList.isEmpty()){
            List<Categories> rootCategories = categoriesMapper.selectList(
                    new EntityWrapper<Categories>().eq("level","1")
            );
            categoriesList.addAll(rootCategories);

            ////////////////////////////////////
            categoriesJob.setStatus("Running");
            categoriesJob.setRunning(true);
            categoriesJob.setStartTime(LocalDateTime.now());
            categoriesJob.setLastUpdate(LocalDateTime.now());
            categoriesJob.setTotal(categoriesList.size());
            crawlerJobMapper.updateById(categoriesJob);
            ////////////////////////////////////
        }

        if(!categoriesList.isEmpty()&&count<categoriesList.size()){
            ////////////////////////////////////
            categoriesJob.setCurrent(count+1);
            categoriesJob.setLastUpdate(LocalDateTime.now());
            crawlerJobMapper.updateById(categoriesJob);
            ////////////////////////////////////

            return categoriesList.get(count++);
        }else{
            ////////////////////////////////////
            categoriesJob.setStatus("Complete");
            categoriesJob.setRunning(false);
            categoriesJob.setEndTime(LocalDateTime.now());
            categoriesJob.setLastUpdate(LocalDateTime.now());
            crawlerJobMapper.updateById(categoriesJob);
            ////////////////////////////////////

            count = 0;
            categoriesList.clear();
            return null;
        }
    }
}
