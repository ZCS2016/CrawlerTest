package com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.crawler;

import com.example.CrawlerTest.crawler.picture.wallpaper.cgwallpaper.entity.CGWallpaper;
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
public class CGWallpaperCrawler {
    @Autowired
    private SeleniumService seleniumService;

    public List<CGWallpaper> getCGWallpaperList(CGWallpaperCategories cgWallpaperCategories){
        List<CGWallpaper> cgWallpapers = new ArrayList<>();

        WebDriver driver = seleniumService.getDriver();

        List<CGWallpaper> pageCGWallpaperList = getPageCGWallpaperList(driver, cgWallpaperCategories);
        cgWallpapers.addAll(pageCGWallpaperList);

        seleniumService.returnDriver(driver);

        return cgWallpapers;
    }

    private List<CGWallpaper> getPageCGWallpaperList(WebDriver driver, CGWallpaperCategories cgWallpaperCategories){
        List<CGWallpaper> cgWallpapers = new ArrayList<>();

        driver.get(cgWallpaperCategories.getSrc());
        List<WebElement> imgElementList = driver.findElements(By.xpath("//div[@id='thumbnails-left-content']/img[@class='zoom123']"));
        for(WebElement imgElement:imgElementList){
            String title = imgElement.getAttribute("alt");
            String img = imgElement.getAttribute("src");
            String src = img;
            String imgName = img.substring(img.indexOf("src=")+4);
            imgName = imgName.substring(0,imgName.indexOf("&"));
            String imgFHD = "https://www.gamewallpapers.com/download.php?img=" + imgName;
//            boolean imgUrlAvailable = PictureDownloadUtil.isImgUrlAvailable(imgFHD);
//            if(!imgUrlAvailable){
//                driver.get(src);
//                WebElement downloadElement = driver.findElement(By.xpath("//a/div[@id='download-button']"));
//                WebElement aDownloadElement = downloadElement.findElement(By.xpath(".."));
//                imgFHD = aDownloadElement.getAttribute("href");
//            }
            String hash = SHAUtil.getSHA256Str(src);

            CGWallpaper cgWallpaper = new CGWallpaper();
            cgWallpaper.setCategoriesId(cgWallpaperCategories.getId());
            cgWallpaper.setPage(1);
            cgWallpaper.setTitle(title);
            cgWallpaper.setSrc(src);
            cgWallpaper.setImg(img);
            cgWallpaper.setImgFHD(imgFHD);
            cgWallpaper.setHash(hash);

            cgWallpapers.add(cgWallpaper);
        }

        return cgWallpapers;
    }
}
