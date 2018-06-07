package com.example.CrawlerTest.config;

import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.processor.GameWallpaperProcessor;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.reader.GameWallpaperReader;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.writer.GameWallpaperWriter;
import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.entity.LinuxWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.processor.LinuxWallpaperProcessor;
import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.reader.LinuxWallpaperReader;
import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.writer.LinuxWallpaperWriter;
import com.example.CrawlerTest.crawler.util.selenium.SeleniumService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    /////////////////////////////////////////////////////////////////////
    //Selenium WebDriver
    @Bean
    public SeleniumService getSeleniumService(){
        SeleniumService seleniumService = new SeleniumService();
        SeleniumService.createAndStartService();
        return seleniumService;
    }
    /////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////
    //Spring Batch
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

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
    public GameWallpaperReader gameWallpaperReader(){
        return new GameWallpaperReader();
    }

    @Bean
    public GameWallpaperProcessor gameWallpaperProcessor(){
        return new GameWallpaperProcessor();
    }

    @Bean
    public GameWallpaperWriter gameWallpaperWriter(){
        return new GameWallpaperWriter();
    }

    @Bean
    public Step gameWallpaperJobStep(){
        return stepBuilderFactory.get("gameWallpaperJobStep")
                .<GameWallpaper,GameWallpaper>chunk(1)
                .reader(gameWallpaperReader())
                .processor(gameWallpaperProcessor())
                .writer(gameWallpaperWriter())
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

    /////////////////////////////////////////////////////////////////////

}
