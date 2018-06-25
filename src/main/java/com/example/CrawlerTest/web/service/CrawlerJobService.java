package com.example.CrawlerTest.web.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.web.dao.CrawlerJobMapper;
import com.example.CrawlerTest.web.entity.CrawlerJob;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class CrawlerJobService {

    @Autowired
    CategoriesMapper categoriesMapper;

    ////////////////////////////////////
    @Autowired
    private CrawlerJobMapper crawlerJobMapper;
    ////////////////////////////////////

    private HashMap<String,ArrayBlockingQueue<Categories>> jobQMap = new HashMap<>();

    public synchronized void startJob(String jobName){
        startJob(jobName,null);
    }

    public synchronized void startJob(String jobName, Integer categoriesId){
        Wrapper<Categories> categoriesWrapper = new EntityWrapper<Categories>();

        switch (jobName){
            case "categoriesListJob":
                categoriesWrapper = categoriesWrapper.eq("level", "0").isNull("img");
                break;
            case "categoriesListImgJob":
                categoriesWrapper = categoriesWrapper.eq("level", "1").isNull("img");
                break;
            case "wallpaperListJob":
                categoriesWrapper = categoriesWrapper.eq("id", categoriesId);
                ////////////////////////////////////
                /**********************************/
                //wallpaperListJob
                Categories categories = categoriesMapper.selectById(categoriesId);
                categories.setCount(0);
                categories.setStatus("Running");
                categories.setRunning(true);
                categories.setCurrent(0);
                categories.setStartTime(LocalDateTime.now());
                categories.setLastUpdate(LocalDateTime.now());
                categoriesMapper.updateById(categories);
                /**********************************/
                ////////////////////////////////////
                break;
            default:
                return;
        }

        ////////////////////////////////////
        CrawlerJob crawlerJob = crawlerJobMapper.selectById(jobName);
        crawlerJob.setStatus("Running");
        crawlerJob.setRunning(true);
        crawlerJob.setCurrent(0);
        /**********************************/
        //wallpaperListJob
        if(jobName.equals("wallpaperListJob")) {
            crawlerJob.setCurrent(categoriesId);
        }
        /**********************************/
        crawlerJob.setStartTime(LocalDateTime.now());
        crawlerJob.setLastUpdate(LocalDateTime.now());
        ////////////////////////////////////

        if(jobQMap.get(jobName) == null || jobQMap.get(jobName).isEmpty()){
            List<Categories> rootCategories = categoriesMapper.selectList(categoriesWrapper);
            if(rootCategories.size()>0) {
                /**********************************/
                //wallpaperListJob
                if(jobName.equals("wallpaperListJob")){
                    Categories rootCategory = rootCategories.get(0);
                    rootCategories.clear();

                    final int totalPageNumber = rootCategory.getTotal();

                    //add pages
                    try {
                        for(int i=0;i<totalPageNumber;i++){
                            Categories rootPageCategory = (Categories)rootCategory.clone();
                            if(i != 0){
                                String pageSrc = rootCategory.getSrc().substring(0,rootCategory.getSrc().indexOf(".html")) + "/page/" + (i+1);
                                rootPageCategory.setSrc(pageSrc);
                            }
                            rootPageCategory.setCurrent(i+1);
                            rootCategories.add(rootPageCategory);
                        }
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                }
                /**********************************/
                ArrayBlockingQueue<Categories> categoriesQ = new ArrayBlockingQueue<Categories>(rootCategories.size());
                categoriesQ.addAll(rootCategories);
                jobQMap.put(jobName, categoriesQ);

                ////////////////////////////////////
                crawlerJob.setTotal(jobQMap.get(jobName).size());
                crawlerJobMapper.updateById(crawlerJob);
                ////////////////////////////////////
            }else{
                jobQMap.put(jobName, null);

                ////////////////////////////////////
                crawlerJob.setTotal(0);
                crawlerJobMapper.updateById(crawlerJob);
                ////////////////////////////////////
            }
        }
    }

    public Categories readRootCategories(String jobName){
        Categories categories = null;

        ////////////////////////////////////
        CrawlerJob crawlerJob = crawlerJobMapper.selectById(jobName);
        ////////////////////////////////////

        if(jobQMap.get(jobName) != null) {
            categories = jobQMap.get(jobName).poll();
            crawlerJob.setCurrent(crawlerJob.getTotal() - jobQMap.get(jobName).size());
        }

        ////////////////////////////////////
        if (categories == null) {
            crawlerJob.setStatus("Complete");
            crawlerJob.setRunning(false);
            crawlerJob.setEndTime(LocalDateTime.now());
        }
        crawlerJob.setLastUpdate(LocalDateTime.now());
        crawlerJobMapper.updateById(crawlerJob);
        ////////////////////////////////////

        return categories;
    }

}
