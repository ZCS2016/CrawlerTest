package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.reader;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler.CategoriesListCrawler;
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

public class CategoriesListReader implements ItemReader<Categories> {
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
//        synchronized(categoriesList) {
            ////////////////////////////////////
            CrawlerJob categoriesJob = crawlerJobMapper.selectById("categoriesListJob");
            ////////////////////////////////////

            if (categoriesJob.getRunning() && categoriesList.isEmpty()) {
                List<Categories> rootCategories = categoriesMapper.selectList(
                        new EntityWrapper<Categories>().eq("level", "0")
                );
                categoriesList.addAll(rootCategories);

                ////////////////////////////////////
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
                Categories categories = categoriesList.get(count++);

                System.out.println(Thread.currentThread().getName()+"/t read: \t"+categories.getId());

                return categories;
            }else{
                ////////////////////////////////////
                categoriesJob.setStatus("Complete");
                categoriesJob.setRunning(false);
                categoriesJob.setEndTime(LocalDateTime.now());
                categoriesJob.setLastUpdate(LocalDateTime.now());
                crawlerJobMapper.updateById(categoriesJob);
                ////////////////////////////////////

                System.out.println(Thread.currentThread().getName()+"/t read: \t"+null);

                count = 0;
                return null;
            }
//        }
    }
}
