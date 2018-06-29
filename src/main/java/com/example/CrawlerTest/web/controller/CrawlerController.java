package com.example.CrawlerTest.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.web.dao.CrawlerJobMapper;
import com.example.CrawlerTest.web.entity.CrawlerJob;
import com.example.CrawlerTest.web.service.CrawlerJobService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/Crawler")
@CrossOrigin(origins = "*")
public class CrawlerController {
    @Autowired
    private CrawlerJobService crawlerJobService;

    @Autowired
    private CrawlerJobMapper crawlerJobMapper;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("categoriesJob")
    private Job categoriesJob;

    @Autowired
    @Qualifier("categoriesListJob")
    private Job categoriesListJob;

    @Autowired
    @Qualifier("categoriesListImgJob")
    private Job categoriesListImgJob;

    @Autowired
    @Qualifier("wallpaperListJob")
    private Job wallpaperListJob;

    @Autowired
    @Qualifier("gameWallpaperCategoriesJob")
    private Job gameWallpaperCategoriesJob;

    @Autowired
    @Qualifier("gameWallpaperJob")
    private Job gameWallpaperJob;

    @RequestMapping("/jobs")
    public List<CrawlerJob> getJobs(){
        List<CrawlerJob> jobs = crawlerJobMapper.selectList(new EntityWrapper<CrawlerJob>());
        return jobs;
    }

    @RequestMapping("/jobs/{jobName}")
    public CrawlerJob getJob(@PathVariable String jobName){
        CrawlerJob job = crawlerJobMapper.selectById(jobName);
        return job;
    }

    @RequestMapping("/run/categoriesJob")
    public String categories(){

        try {
            jobLauncher.run(categoriesJob,jobParameters());
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }

        return "categories Done!";
    }

    @RequestMapping("/run/categoriesListJob")
    public String categoriesList(){

        try {
            crawlerJobService.startJob("categoriesListJob");
            jobLauncher.run(categoriesListJob,jobParameters());
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }

        return "categoriesList Done!";
    }

    @RequestMapping("/run/categoriesListImgJob")
    public String categoriesListImg(){

        try {
            crawlerJobService.startJob("categoriesListImgJob");
            jobLauncher.run(categoriesListImgJob,jobParameters());
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }

        return "categoriesListImg Done!";
    }

    @RequestMapping("/run/wallpaperListJob/{categoriesId}")
    public String wallpaperListJob(@PathVariable Integer categoriesId){

        try {
            crawlerJobService.startJob("wallpaperListJob",categoriesId);
            jobLauncher.run(wallpaperListJob,jobParameters());
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }

        return "wallpaperListJob Done!";
    }

    @RequestMapping("/run/gameWallpaperCategoriesJob")
    public String runGameWallpaperCategoriesJob(){

        try {
            jobLauncher.run(gameWallpaperCategoriesJob,jobParameters());
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }

        return "GameWallpaperCategoriesJob Done!";
    }

    @RequestMapping("/run/gameWallpaperJob")
    public String runGameWallpaperJob(){

        try {
            jobLauncher.run(gameWallpaperJob,jobParameters());
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }

        return "GameWallpaperJob Done!";
    }

    public JobParameters jobParameters(){
        return new JobParametersBuilder()
                .addDate("time",new Date())
                .toJobParameters();
    }

}
