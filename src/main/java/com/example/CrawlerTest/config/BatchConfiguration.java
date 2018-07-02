package com.example.CrawlerTest.config;

import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.processor.GameWallpaperCategoriesProcessor;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.processor.GameWallpaperDownloadProcessor;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.processor.GameWallpaperProcessor;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.reader.GameWallpaperCategoriesReader;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.reader.GameWallpaperDownloadReader;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.reader.GameWallpaperReader;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.writer.GameWallpaperCategoriesWriter;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.writer.GameWallpaperDownloadWriter;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.writer.GameWallpaperWriter;
import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.entity.LinuxWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.processor.LinuxWallpaperProcessor;
import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.reader.LinuxWallpaperReader;
import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.writer.LinuxWallpaperWriter;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.processor.CategoriesListImgProcessor;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.processor.CategoriesListProcessor;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.processor.CategoriesProcessor;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.processor.WallpaperListProcessor;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.reader.CategoriesListImgReader;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.reader.CategoriesListReader;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.reader.CategoriesReader;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.reader.WallpaperListReader;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.writer.CategoriesWriter;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.writer.WallpaperWriter;
import com.example.CrawlerTest.crawler.util.io.download.MultiThreadPictureDownloadService;
import com.example.CrawlerTest.crawler.util.selenium.SeleniumService;
import com.example.CrawlerTest.crawler.util.selenium.WebDriverFactory;
import com.example.CrawlerTest.web.service.CrawlerJobService;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.IOException;
import java.util.Date;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    public static final int POOL_SIZE = 4;
    public static final int PICTURE_DOWNLOAD_THREAD_POOL_SIZE = 4;

    /////////////////////////////////////////////////////////////////////
    //Selenium WebDriver
    @Bean
    public WebDriverFactory getWebDriverFactory(){
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        WebDriverFactory.createAndStartService();
        return webDriverFactory;
    }

    @Bean
    public GenericObjectPoolConfig getWebDriverPoolConfig(){
        GenericObjectPoolConfig webDriverPoolConfig = new GenericObjectPoolConfig();
        webDriverPoolConfig.setMaxTotal(POOL_SIZE);
        return webDriverPoolConfig;
    }

    @Bean
    public GenericObjectPool<WebDriver> getWebDriverPool(WebDriverFactory webDriverFactory,GenericObjectPoolConfig webDriverPoolConfig){
        GenericObjectPool<WebDriver> webDriverPool = new GenericObjectPool<WebDriver>(webDriverFactory,webDriverPoolConfig);
        return webDriverPool;
    }

    @Bean
    public SeleniumService getSeleniumService(){
        SeleniumService seleniumService = new SeleniumService();
        return seleniumService;
    }

    @Bean
    public CrawlerJobService getCrawlerJobService(){
        CrawlerJobService crawlerJobService = new CrawlerJobService();
        return crawlerJobService;
    }

    @Bean
    public MultiThreadPictureDownloadService getMultiThreadPictureDownloadService(){
        return new MultiThreadPictureDownloadService(PICTURE_DOWNLOAD_THREAD_POOL_SIZE);
    }

    /////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////
    //Spring Batch
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public JobRepository jobRepository;

    @Bean
    public TaskExecutor getTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(POOL_SIZE);
        return taskExecutor;
    };

    @Bean
    public JobLauncher jobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }

    //Jobs
    /////////////////////////////////////////////////////////////////////
    //LinuxWallpaper

//    @Bean
//    public LinuxWallpaperReader linuxWallpaperReader() {
//        return new LinuxWallpaperReader();
//    }
//
//    @Bean
//    public LinuxWallpaperProcessor linuxWallpaperProcessor(){
//        return new LinuxWallpaperProcessor();
//    }
//
//    @Bean
//    public LinuxWallpaperWriter linuxWallpaperWriter(){
//        return new LinuxWallpaperWriter();
//    }
//
//    @Bean
//    public Step linuxWallpaperJobStep(){
//        return stepBuilderFactory.get("linuxWallpaperJobStep")
//                .<LinuxWallpaper,LinuxWallpaper>chunk(1)
//                .reader(linuxWallpaperReader())
//                .processor(linuxWallpaperProcessor())
//                .writer(linuxWallpaperWriter())
//                .build();
//    }
//
//    @Bean
//    public Job linuxWallpaperJob(Step linuxWallpaperJobStep){
//        return jobBuilderFactory.get("linuxWallpaperJob")
//                .incrementer(new RunIdIncrementer())
//                .flow(linuxWallpaperJobStep)
//                .end()
//                .build();
//    }
    /////////////////////////////////////////////////////////////////////



    /////////////////////////////////////////////////////////////////////
    //GameWallpaper
    @Bean
    public GameWallpaperCategoriesReader getGameWallpaperCategoriesReader(){
        return new GameWallpaperCategoriesReader();
    }

    @Bean
    public GameWallpaperCategoriesProcessor getGameWallpaperCategoriesProcessor(){
        return new GameWallpaperCategoriesProcessor();
    }

    @Bean
    public GameWallpaperCategoriesWriter getGameWallpaperCategoriesWriter(){
        return new GameWallpaperCategoriesWriter();
    }

    @Bean
    public Step gameWallpaperCategoriesJobStep(){
        return stepBuilderFactory.get("gameWallpaperCategoriesJobStep")
                .<GameWallpaperCategories,GameWallpaperCategories>chunk(1)
                .reader(getGameWallpaperCategoriesReader())
                .processor(getGameWallpaperCategoriesProcessor())
                .writer(getGameWallpaperCategoriesWriter())
                .build();
    }

    @Bean
    public Job gameWallpaperCategoriesJob(Step gameWallpaperCategoriesJobStep){
        return jobBuilderFactory.get("gameWallpaperCategoriesJob")
                .incrementer(new RunIdIncrementer())
                .flow(gameWallpaperCategoriesJobStep)
                .end()
                .build();
    }

    @Bean
    public GameWallpaperReader getGameWallpaperReader(){
        return new GameWallpaperReader();
    }

    @Bean
    public GameWallpaperProcessor getGameWallpaperProcessor(){
        return new GameWallpaperProcessor();
    }

    @Bean
    public GameWallpaperWriter getGameWallpaperWriter(){
        return new GameWallpaperWriter();
    }

    @Bean
    public Step gameWallpaperJobStep(){
        return stepBuilderFactory.get("gameWallpaperJobStep")
                .<GameWallpaperCategories,GameWallpaperCategories>chunk(1)
                .reader(getGameWallpaperReader())
                .processor(getGameWallpaperProcessor())
                .writer(getGameWallpaperWriter())
                .build();
    }

    @Bean
    public Job gameWallpaperJob(Step gameWallpaperJobStep){
        return jobBuilderFactory.get("gameWallpaperJob")
                .incrementer(new RunIdIncrementer())
                .flow(gameWallpaperJobStep)
                .end()
                .build();
    }

    @Bean
    public GameWallpaperDownloadReader getGameWallpaperDownloadReader(){
        return new GameWallpaperDownloadReader();
    }

    @Bean
    public GameWallpaperDownloadProcessor getGameWallpaperDownloadProcessor(){
        return new GameWallpaperDownloadProcessor();
    }

    @Bean
    public GameWallpaperDownloadWriter getGameWallpaperDownloadWriter(){
        return new GameWallpaperDownloadWriter();
    }

    @Bean
    public Step gameWallpaperDownloadJobStep(){
        return stepBuilderFactory.get("gameWallpaperDownloadJobStep")
                .<GameWallpaper,GameWallpaper>chunk(1)
                .reader(getGameWallpaperDownloadReader())
                .processor(getGameWallpaperDownloadProcessor())
                .writer(getGameWallpaperDownloadWriter())
                .build();
    }

    @Bean
    public Job gameWallpaperDownloadJob(Step gameWallpaperDownloadJobStep){
        return jobBuilderFactory.get("gameWallpaperDownloadJob")
                .incrementer(new RunIdIncrementer())
                .flow(gameWallpaperDownloadJobStep)
                .end()
                .build();
    }

    /////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////
    //Wallpaperswide_Categories

    @Bean
    public CategoriesReader categoriesReader(){
        return new CategoriesReader();
    }

    @Bean
    public CategoriesListReader categoriesListReader(){
        return new CategoriesListReader();
    }

    @Bean
    public CategoriesListImgReader categoriesListImgReader(){
        return new CategoriesListImgReader();
    }

    @Bean
    public WallpaperListReader wallpaperListReader(){
        return new WallpaperListReader();
    }

    @Bean
    public CategoriesProcessor categoriesProcessor(){
        return new CategoriesProcessor();
    }

    @Bean
    public CategoriesListProcessor categoriesListProcessor(){
        return new CategoriesListProcessor();
    }

    @Bean
    public CategoriesListImgProcessor categoriesListImgProcessor(){
        return new CategoriesListImgProcessor();
    }

    @Bean
    public WallpaperListProcessor wallpaperListProcessor(){
        return new WallpaperListProcessor();
    }

    @Bean
    public CategoriesWriter categoriesWriter(){
        return new CategoriesWriter();
    }

    @Bean
    public WallpaperWriter wallpaperWriter(){
        return new WallpaperWriter();
    }


    @Bean
    public Step categoriesJobStep(){
        return stepBuilderFactory.get("categoriesJobStep")
                .<Categories,Categories>chunk(1)
                .reader(categoriesReader())
                .processor(categoriesProcessor())
                .writer(categoriesWriter())
                .build();
    }

    @Bean
    public Job categoriesJob(Step categoriesJobStep){
        return jobBuilderFactory.get("categoriesJob")
                .incrementer(new RunIdIncrementer())
                .flow(categoriesJobStep)
                .end()
                .build();
    }

    @Bean
    public Step categoriesListJobStep(TaskExecutor taskExecutor){
        return stepBuilderFactory.get("categoriesListJobStep")
                .<Categories,Categories>chunk(1)
                .reader(categoriesListReader())
                .processor(categoriesListProcessor())
                .writer(categoriesWriter())
                .taskExecutor(taskExecutor)
                .build();
    }

    @Bean
    public Job categoriesListJob(Step categoriesListJobStep){
        return jobBuilderFactory.get("categoriesListJob")
                .incrementer(new RunIdIncrementer())
                .flow(categoriesListJobStep)
                .end()
                .build();
    }

    @Bean
    public Step categoriesListImgJobStep(TaskExecutor taskExecutor){
        return stepBuilderFactory.get("categoriesListImgJobStep")
                .<Categories,Categories>chunk(1)
                .reader(categoriesListImgReader())
                .processor(categoriesListImgProcessor())
                .writer(categoriesWriter())
                .taskExecutor(taskExecutor)
                .build();
    }

    @Bean
    public Job categoriesListImgJob(Step categoriesListImgJobStep){
        return jobBuilderFactory.get("categoriesListImgJob")
                .incrementer(new RunIdIncrementer())
                .flow(categoriesListImgJobStep)
                .end()
                .build();
    }

    @Bean
    public Step wallpaperListJobStep(TaskExecutor taskExecutor){
        return stepBuilderFactory.get("wallpaperListJobStep")
                .<Categories,Categories>chunk(1)
                .reader(wallpaperListReader())
                .processor(wallpaperListProcessor())
                .writer(wallpaperWriter())
                .taskExecutor(taskExecutor)
                .build();
    }

    @Bean
    public Job wallpaperListJob(Step wallpaperListJobStep){
        return jobBuilderFactory.get("wallpaperListJob")
                .incrementer(new RunIdIncrementer())
                .flow(wallpaperListJobStep)
                .end()
                .build();
    }

    /////////////////////////////////////////////////////////////////////

}
