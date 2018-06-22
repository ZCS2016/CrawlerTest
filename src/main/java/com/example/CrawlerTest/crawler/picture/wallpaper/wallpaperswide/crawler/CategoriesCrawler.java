package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler;

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
import java.util.Date;
import java.util.List;

@Component
public class CategoriesCrawler {
    ////////////////////////////////////
    @Autowired
    private CrawlerJobMapper crawlerJobMapper;
    ////////////////////////////////////

    @Autowired
    private SeleniumService seleniumService;

    public List<Categories> getCategoriesList(Categories rootCategories){
        List<Categories> categoriesList = new ArrayList<>();

        ////////////////////////////////////
        CrawlerJob categoriesJob = crawlerJobMapper.selectById("categoriesJob");
        categoriesJob.setStatus("Running");
        categoriesJob.setRunning(true);
        categoriesJob.setStartTime(LocalDateTime.now());
        categoriesJob.setLastUpdate(LocalDateTime.now());
        crawlerJobMapper.updateById(categoriesJob);
        ////////////////////////////////////

        final String baseUrl = rootCategories.getSrc();
        WebDriver driver = seleniumService.getDriver();
        driver.get(baseUrl);

        List<WebElement> categoriesElementList = driver.findElements(By.xpath("//ul[@class='side-panel categories']/li"));
        ////////////////////////////////////
        categoriesJob.setTotal(categoriesElementList.size());
        categoriesJob.setLastUpdate(LocalDateTime.now());
        crawlerJobMapper.updateById(categoriesJob);
        ////////////////////////////////////
        for(WebElement categoriesElement:categoriesElementList){
            WebElement aElement = categoriesElement.findElement(By.tagName("a"));
            WebElement smallElement = categoriesElement.findElement(By.tagName("small"));

            String title = aElement.getText();
            String src = aElement.getAttribute("href");
            String count = smallElement.getText().substring(1,smallElement.getText().length()-1);
            Integer level = 0;
            String hash = SHAUtil.getSHA256Str(src);

            Categories categories = new Categories();
            categories.setTitle(title);
            categories.setSrc(src);
            categories.setCount(count);
            categories.setLevel(level);
            categories.setParentId(-1);
            categories.setHash(hash);

            categoriesList.add(categories);

            ////////////////////////////////////
            categoriesJob.setCurrent(categoriesList.size());
            categoriesJob.setLastUpdate(LocalDateTime.now());
            crawlerJobMapper.updateById(categoriesJob);
            ////////////////////////////////////
        }

        seleniumService.returnDriver(driver);

        ////////////////////////////////////
        categoriesJob.setStatus("Complete");
        categoriesJob.setRunning(false);
        categoriesJob.setEndTime(LocalDateTime.now());
        categoriesJob.setLastUpdate(LocalDateTime.now());
        crawlerJobMapper.updateById(categoriesJob);
        ////////////////////////////////////

        return categoriesList;
    }

}
