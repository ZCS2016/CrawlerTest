package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler;

import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Wallpaper;
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
public class WallpaperListCrawler {
    @Autowired
    private SeleniumService seleniumService;

    public List<Wallpaper> getWallpaperList(Categories rootCategories){
        List<Wallpaper> WallpaperList = new ArrayList<>();

        WebDriver driver = seleniumService.getDriver();

        List<Wallpaper> pageWallpaperList = getPageWallpaperList(driver,rootCategories);
        WallpaperList.addAll(pageWallpaperList);

        seleniumService.returnDriver(driver);

        return WallpaperList;
    }

    private List<Wallpaper> getPageWallpaperList(WebDriver driver, Categories rootCategories){
        List<Wallpaper> WallpaperList = new ArrayList<>();

        driver.get(rootCategories.getSrc());
        List<WebElement> imgElementList = driver.findElements(By.className("thumb_img"));
        for(WebElement imgElement:imgElementList){
            WebElement aElement = imgElement.findElement(By.xpath(".."));

            String title = aElement.getAttribute("title");
            String src = aElement.getAttribute("href");
            String img = imgElement.getAttribute("src");
            String hash = SHAUtil.getSHA256Str(src);

            Wallpaper wallpaper = new Wallpaper();
            wallpaper.setCategories_id(rootCategories.getId());
            wallpaper.setPage(rootCategories.getCurrent());
            wallpaper.setTitle(title);
            wallpaper.setSrc(src);
            wallpaper.setImg(img);
            wallpaper.setHash(hash);

            WallpaperList.add(wallpaper);
        }

        return WallpaperList;
    }
}
