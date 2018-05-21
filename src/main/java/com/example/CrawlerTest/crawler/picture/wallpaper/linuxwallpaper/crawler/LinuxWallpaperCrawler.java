package com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.crawler;

import com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.entity.LinuxWallpaper;
import com.example.CrawlerTest.crawler.util.selenium.SeleniumService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LinuxWallpaperCrawler {

    @Autowired
    private SeleniumService seleniumService;

    public List<LinuxWallpaper> getLinuxWallpaperList(){
        List<LinuxWallpaper> linuxWallpaperList = new ArrayList<>();

        WebDriver driver = seleniumService.getDriver();
        driver.get("https://www.linuxidc.com/Linuxwallpaper/");
        List<WebElement> imgElementList = driver.findElements(By.className("imgLink"));
        for(WebElement imgElement:imgElementList){
            String title = imgElement.getText();
            WebElement aElement = imgElement.findElement(By.tagName("img"));
            String src =aElement.getAttribute("src");

            linuxWallpaperList.add(new LinuxWallpaper(title,src));
        }
        driver.close();

        return linuxWallpaperList;
    }

}
