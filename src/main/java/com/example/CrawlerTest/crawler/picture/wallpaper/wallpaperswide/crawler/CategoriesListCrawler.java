package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.crawler.util.codec.SHAUtil;
import com.example.CrawlerTest.crawler.util.selenium.SeleniumService;
import com.example.CrawlerTest.web.dao.CrawlerJobMapper;
import com.example.CrawlerTest.web.entity.CrawlerJob;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriesListCrawler {
    ////////////////////////////////////
    @Autowired
    private CrawlerJobMapper crawlerJobMapper;
    ////////////////////////////////////

    @Autowired
    private SeleniumService seleniumService;

    @Autowired
    CategoriesMapper categoriesMapper;

    public List<Categories> getCategoriesList(List<Categories> categories){
        List<Categories> categoriesList = new ArrayList<>();

        ////////////////////////////////////
        CrawlerJob categoriesJob = crawlerJobMapper.selectById("categoriesListJob");
        categoriesJob.setStatus("Running");
        categoriesJob.setRunning(true);
        categoriesJob.setStartTime(LocalDateTime.now());
        categoriesJob.setLastUpdate(LocalDateTime.now());
        categoriesJob.setTotal(categories.size());
        crawlerJobMapper.updateById(categoriesJob);
        ////////////////////////////////////
        WebDriver driver = seleniumService.getDriver();

        for(int i=0; i < categories.size(); i++ ){
            Categories category = categories.get(i);
            List<Categories> pageCategoriesList = getPageCategoriesList(driver, category);
            categoriesList.addAll(pageCategoriesList);

            ////////////////////////////////////
            categoriesJob.setCurrent(i+1);
            categoriesJob.setLastUpdate(LocalDateTime.now());
            crawlerJobMapper.updateById(categoriesJob);
            ////////////////////////////////////
        }

        ////////////////////////////////////
        categoriesJob.setStatus("Complete");
        categoriesJob.setRunning(false);
        categoriesJob.setEndTime(LocalDateTime.now());
        categoriesJob.setLastUpdate(LocalDateTime.now());
        crawlerJobMapper.updateById(categoriesJob);
        ////////////////////////////////////

        return categoriesList;
    }

    public List<Categories> getPageCategoriesList(WebDriver driver,Categories category){
        List<Categories> categoriesList = new ArrayList<>();

        driver.get(category.getSrc());

        //Update parent category.img
        List<WebElement> imgElementList = driver.findElements(By.className("thumb_img"));
        if(imgElementList.size()>0){
            WebElement imgElement = imgElementList.get(0);
            String imgSrc = imgElement.getAttribute("src");
            category.setImg(imgSrc);
            categoriesMapper.updateById(category);
        }

        List<WebElement> categoriesElementList = driver.findElements(By.xpath("//ul[@class='side-panel categories']/li[@style='padding-left:5px;']"));
        for(WebElement categoriesElement:categoriesElementList){
            WebElement aElement = categoriesElement.findElement(By.tagName("a"));
            WebElement smallElement = categoriesElement.findElement(By.tagName("small"));

            String title = aElement.getText();
            String src = aElement.getAttribute("href");
            String count = smallElement.getText().substring(1,smallElement.getText().length()-1);
            Integer level = 1;
            String hash = SHAUtil.getSHA256Str(src);

            Categories categories = new Categories();
            categories.setTitle(title);
            categories.setSrc(src);
            categories.setCount(count);
            categories.setLevel(level);
            categories.setParentId(category.getId());
            categories.setHash(hash);

            categoriesList.add(categories);
        }

        return categoriesList;
    }
}
