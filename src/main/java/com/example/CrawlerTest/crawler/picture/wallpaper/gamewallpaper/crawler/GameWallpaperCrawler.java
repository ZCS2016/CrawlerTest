package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.crawler;

import com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity.GameWallpaper;
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

    public List<GameWallpaper> getGameWallpaperList(){
        List<GameWallpaper> gameWallpaperList = new ArrayList<>();

        final int pageNumber = 10;
        String[] urls = new String[pageNumber];
        urls[0] = "http://wallpaperswide.com/games-desktop-wallpapers.html";
        for(int i=1;i<pageNumber;i++){
            urls[i] = "http://wallpaperswide.com/games-desktop-wallpapers/page/"+(i+1);
        }

        WebDriver driver = seleniumService.getDriver();

        for(int i=0;i<pageNumber;i++) {
            List<GameWallpaper> pageGameWallpaperList = getPageGameWallpaperList(driver, urls[i]);
            gameWallpaperList.addAll(pageGameWallpaperList);
        }

        driver.close();

        return gameWallpaperList;
    }

    private List<GameWallpaper> getPageGameWallpaperList(WebDriver driver,String url){
        List<GameWallpaper> gameWallpaperList = new ArrayList<>();

        driver.get(url);
        List<WebElement> imgElementList = driver.findElements(By.className("thumb_img"));
        for(WebElement imgElement:imgElementList){
            String src = imgElement.getAttribute("src");
            String title = src.substring(src.lastIndexOf("/")+1,src.lastIndexOf(".jpg"));
            String hash = SHAUtil.getSHA256Str(src);

            GameWallpaper gameWallpaper = new GameWallpaper();
            gameWallpaper.setTitle(title);
            gameWallpaper.setSrc(src);
            gameWallpaper.setHash(hash);

            gameWallpaperList.add(gameWallpaper);
        }

        return gameWallpaperList;
    }
}
