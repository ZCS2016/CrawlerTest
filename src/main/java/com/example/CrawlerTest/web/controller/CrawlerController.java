package com.example.CrawlerTest.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.web.dao.CrawlerJobMapper;
import com.example.CrawlerTest.web.entity.CrawlerJob;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/Crawler")
@CrossOrigin(origins = "*")
public class CrawlerController {
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


    public JobParameters jobParameters(){
        return new JobParametersBuilder()
                .addDate("time",new Date())
                .toJobParameters();
    }

}
