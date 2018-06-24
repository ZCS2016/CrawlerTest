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
public class CategoriesListImgCrawler {

    @Autowired
    private SeleniumService seleniumService;

    @Autowired
    CategoriesMapper categoriesMapper;

    public List<Categories> getCategoriesListImg(Categories rootCategories){
        List<Categories> categoriesList = new ArrayList<>();


        WebDriver driver = seleniumService.getDriver();

        List<Categories> pageCategoriesList = getPageCategoriesListImg(driver, rootCategories);
        categoriesList.addAll(pageCategoriesList);

        seleniumService.returnDriver(driver);

        return categoriesList;
    }

    public List<Categories> getPageCategoriesListImg(WebDriver driver,Categories category){
        List<Categories> categoriesList = new ArrayList<>();

        driver.get(category.getSrc());

        //Update parent category.img
        List<WebElement> imgElementList = driver.findElements(By.className("thumb_img"));
        if(imgElementList.size()>0){
            WebElement imgElement = imgElementList.get(0);
            String imgSrc = imgElement.getAttribute("src");
            category.setImg(imgSrc);

        }

        //Update parent category.total
        List<WebElement> paginationList = driver.findElements(By.className("pagination"));

        if(paginationList.size()>1) {
            WebElement paginationElement = paginationList.get(1);
            List<WebElement> paginationElementList = paginationElement.findElements(By.tagName("a"));
            if (paginationElementList.size() > 1 && paginationElementList.get(paginationElementList.size() - 1).getText().equals("Next »")) {
                WebElement totalElement = paginationElementList.get(paginationElementList.size() - 2);
                String totalStr = totalElement.getText();
                Integer total = Integer.parseInt(totalStr);
                category.setTotal(total);
            }
        }else{
            WebElement paginationElement = paginationList.get(0);
            List<WebElement> paginationElementList = paginationElement.findElements(By.tagName("a"));
            if (paginationElementList.size() > 1 && paginationElementList.get(paginationElementList.size() - 1).getText().equals("Next »")) {
                WebElement totalElement = paginationElementList.get(paginationElementList.size() - 2);
                String totalStr = totalElement.getText();
                Integer total = Integer.parseInt(totalStr);
                category.setTotal(total);
            } else {
                paginationElementList = paginationElement.findElements(By.tagName("span"));
                if (paginationElementList.size() > 1 && paginationElementList.get(paginationElementList.size() - 1).getText().equals("Next »")) {
                    WebElement totalElement = paginationElementList.get(paginationElementList.size() - 2);
                    String totalStr = totalElement.getText();
                    Integer total = Integer.parseInt(totalStr);
                    category.setTotal(total);
                }
            }
        }


        categoriesMapper.updateById(category);

        return categoriesList;
    }
}
