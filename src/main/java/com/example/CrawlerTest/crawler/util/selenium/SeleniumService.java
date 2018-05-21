package com.example.CrawlerTest.crawler.util.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class SeleniumService {
    private static ChromeDriverService service;
    private WebDriver driver;

    public static void createAndStartService() {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("D:/Java/Crawler/Selenium/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createAndStopService() {
        service.stop();
    }

    public void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
    }

    public void quitDriver() {
        driver.quit();
    }

    public WebDriver getDriver() {
        if(driver==null){
            createDriver();
        }
        return driver;
    }

}
