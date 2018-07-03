package com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.crawler;

import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaperCategories;
import com.example.CrawlerTest.crawler.util.codec.SHAUtil;
import com.example.CrawlerTest.crawler.util.selenium.SeleniumService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CGWallpaperCategoriesCrawler {
    @Autowired
    private SeleniumService seleniumService;

    public List<CGWallpaperCategories> getCGWallpaperCategoriesList(String rootCategoriesUrl){
        List<CGWallpaperCategories> cgWallpaperCategoriesList = new ArrayList<>();

        WebDriver driver = seleniumService.getDriver();

        driver.get(rootCategoriesUrl);
        List<WebElement> aElements = driver.findElements(By.xpath("//div[@id='directory']/p/a"));
        for(WebElement aElement:aElements){
            String title = aElement.getText();
            String src = aElement.getAttribute("href");
            String hash = SHAUtil.getSHA256Str(src);

            CGWallpaperCategories cgWallpaperCategories = new CGWallpaperCategories();
            cgWallpaperCategories.setTitle(title);
            cgWallpaperCategories.setSrc(src);
            cgWallpaperCategories.setHash(hash);

            cgWallpaperCategoriesList.add(cgWallpaperCategories);
        }

        seleniumService.returnDriver(driver);

        return cgWallpaperCategoriesList;
    }
}
