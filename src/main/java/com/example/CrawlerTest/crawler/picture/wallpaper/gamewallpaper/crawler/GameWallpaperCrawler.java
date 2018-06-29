package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.crawler;

import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaperCategories;
import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.entity.LinuxWallpaper;
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
public class GameWallpaperCrawler {

    @Autowired
    private SeleniumService seleniumService;

    public List<GameWallpaper> getGameWallpaperList(GameWallpaperCategories gameWallpaperCategories){
        List<GameWallpaper> gameWallpaperList = new ArrayList<>();

        WebDriver driver = seleniumService.getDriver();

        List<GameWallpaper> pageGameWallpaperList = getPageGameWallpaperList(driver, gameWallpaperCategories);
        gameWallpaperList.addAll(pageGameWallpaperList);

        seleniumService.returnDriver(driver);

        return gameWallpaperList;
    }

    private List<GameWallpaper> getPageGameWallpaperList(WebDriver driver,GameWallpaperCategories gameWallpaperCategories){
        List<GameWallpaper> gameWallpaperList = new ArrayList<>();

        driver.get(gameWallpaperCategories.getSrc());
        List<WebElement> imgElementList = driver.findElements(By.xpath("//img[@class='zoom123']"));
        for(WebElement imgElement:imgElementList){
            WebElement aElement = imgElement.findElement(By.xpath(".."));

            String title = imgElement.getAttribute("alt");
            String img = imgElement.getAttribute("src");
            String src = aElement.getAttribute("href");
            String hash = SHAUtil.getSHA256Str(src);

            GameWallpaper gameWallpaper = new GameWallpaper();
            gameWallpaper.setCategoriesId(gameWallpaperCategories.getId());
            gameWallpaper.setPage(1);
            gameWallpaper.setTitle(title);
            gameWallpaper.setSrc(src);
            gameWallpaper.setImg(img);
            gameWallpaper.setHash(hash);

            gameWallpaperList.add(gameWallpaper);
        }

        return gameWallpaperList;
    }
}
