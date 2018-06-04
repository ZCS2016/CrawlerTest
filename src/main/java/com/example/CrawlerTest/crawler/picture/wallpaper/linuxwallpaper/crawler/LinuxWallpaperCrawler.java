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

        final int pageNumber = 5;
        String[] urls = new String[pageNumber];
        urls[0] = "https://www.linuxidc.com/Linuxwallpaper/";
        for(int i=1;i<pageNumber;i++) {
            urls[i] = "https://www.linuxidc.com/Linuxwallpaper/indexp" + (i+1) + ".htm";
        }

        WebDriver driver = seleniumService.getDriver();

        for(int i=0;i<pageNumber;i++) {
            List<LinuxWallpaper> pageLinuxWallpaperList = getPageLinuxWallpaperList(driver,urls[i]);
            linuxWallpaperList.addAll(pageLinuxWallpaperList);
        }

        driver.close();

        return linuxWallpaperList;
    }

    private List<LinuxWallpaper> getPageLinuxWallpaperList(WebDriver driver,String url) {
        List<LinuxWallpaper> linuxWallpaperList = new ArrayList<>();

        driver.get(url);
        List<WebElement> imgElementList = driver.findElements(By.className("imgLink"));
        for(WebElement imgElement:imgElementList){
            String title = imgElement.getText();
            WebElement aElement = imgElement.findElement(By.tagName("img"));
            String src =aElement.getAttribute("src");

            linuxWallpaperList.add(new LinuxWallpaper(title,src));
        }

        return linuxWallpaperList;
    }

}
