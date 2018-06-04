package com.example.CrawlerTest.crawler.picture.wallpaper.linuxwallpaper.entity;

public class LinuxWallpaper {
    private String id;
    private String title;
    private String src;

    public LinuxWallpaper() {
    }

    public LinuxWallpaper(String title, String src) {
        this.title = title;
        this.src = src;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
