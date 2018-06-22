package com.example.CrawlerTest.web.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.web.dao.CrawlerJobMapper;
import com.example.CrawlerTest.web.entity.CrawlerJob;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class CrawlerJobService {

    @Autowired
    CategoriesMapper categoriesMapper;

    ////////////////////////////////////
    @Autowired
    private CrawlerJobMapper crawlerJobMapper;
    ////////////////////////////////////

    private ArrayBlockingQueue<Categories> categoriesListQ;

    public synchronized void startCategoriesListJob(){
        if(categoriesListQ == null || categoriesListQ.isEmpty()){
            List<Categories> rootCategories = categoriesMapper.selectList(
                    new EntityWrapper<Categories>().eq("level", "0")
            );
            categoriesListQ = new ArrayBlockingQueue<Categories>(rootCategories.size());
            categoriesListQ.addAll(rootCategories);
        }

        ////////////////////////////////////
        CrawlerJob categoriesListCrawlerJob = crawlerJobMapper.selectById("categoriesListJob");
        categoriesListCrawlerJob.setStatus("Running");
        categoriesListCrawlerJob.setRunning(true);
        categoriesListCrawlerJob.setCurrent(0);
        categoriesListCrawlerJob.setTotal(categoriesListQ.size());
        categoriesListCrawlerJob.setStartTime(LocalDateTime.now());
        categoriesListCrawlerJob.setLastUpdate(LocalDateTime.now());
        crawlerJobMapper.updateById(categoriesListCrawlerJob);
        ////////////////////////////////////
    }

    public Categories readCategoriesList(){
        Categories categories = categoriesListQ.poll();

        ////////////////////////////////////
        CrawlerJob categoriesListCrawlerJob = crawlerJobMapper.selectById("categoriesListJob");
        categoriesListCrawlerJob.setCurrent(categoriesListCrawlerJob.getTotal() - categoriesListQ.size());
        if(categoriesListCrawlerJob.getCurrent() == categoriesListCrawlerJob.getTotal()){
            categoriesListCrawlerJob.setStatus("Complete");
            categoriesListCrawlerJob.setRunning(false);
            categoriesListCrawlerJob.setEndTime(LocalDateTime.now());
        }
        categoriesListCrawlerJob.setLastUpdate(LocalDateTime.now());
        crawlerJobMapper.updateById(categoriesListCrawlerJob);
        ////////////////////////////////////

        return categories;
    }
}
