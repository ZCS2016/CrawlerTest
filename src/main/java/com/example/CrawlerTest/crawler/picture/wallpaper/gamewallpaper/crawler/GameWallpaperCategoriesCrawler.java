package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.crawler;

import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
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
public class GameWallpaperCategoriesCrawler {
    @Autowired
    private SeleniumService seleniumService;

    public List<GameWallpaperCategories> getGameWallpaperCategoriesList(String rootCategoriesUrl){
        List<GameWallpaperCategories> gameWallpaperCategoriesList = new ArrayList<>();

        WebDriver driver = seleniumService.getDriver();

        driver.get(rootCategoriesUrl);
        List<WebElement> aElements = driver.findElements(By.xpath("//div[@id='directory']/p/a"));
        for(WebElement aElement:aElements){
            WebElement spanElement = null;
            try {
                spanElement = aElement.findElement(By.tagName("span"));
            }catch (Exception e){

            }

            if(spanElement == null){
                String title = aElement.getText();
                String src = aElement.getAttribute("href");
                String hash = SHAUtil.getSHA256Str(src);

                GameWallpaperCategories gameWallpaperCategories = new GameWallpaperCategories();
                gameWallpaperCategories.setTitle(title);
                gameWallpaperCategories.setSrc(src);
                gameWallpaperCategories.setHash(hash);

                gameWallpaperCategoriesList.add(gameWallpaperCategories);
            }else{
                continue;
            }
        }

        seleniumService.returnDriver(driver);

        return gameWallpaperCategoriesList;
    }
}
