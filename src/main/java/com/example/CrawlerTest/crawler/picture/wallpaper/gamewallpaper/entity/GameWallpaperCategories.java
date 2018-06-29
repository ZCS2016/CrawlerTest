package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.ArrayList;
import java.util.List;

@TableName("gamewallpaper_categories")
public class GameWallpaperCategories {
    private Integer id;
    private String title;
    private String src;
    private String img;
    private Integer count;
    private String hash;

    @TableField(exist = false)
    private List<GameWallpaper> childrenWallpapers = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public List<GameWallpaper> getChildrenWallpapers() {
        return childrenWallpapers;
    }

    public void setChildrenWallpapers(List<GameWallpaper> childrenWallpapers) {
        this.childrenWallpapers = childrenWallpapers;
    }
}
