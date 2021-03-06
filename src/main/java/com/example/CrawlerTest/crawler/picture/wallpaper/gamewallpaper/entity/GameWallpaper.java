package com.example.CrawlerTest.crawler.picture.wallpaper.gamewallpaper.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("gamewallpaper_wallpaper")
public class GameWallpaper {
    private Integer id;
    private Integer categoriesId;
    private Integer page;
    private String title;
    private String src;
    private String img;
    @TableField("img_hd")
    private String imgHD;
    @TableField("img_fhd")
    private String imgFHD;
    private String hash;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Integer categoriesId) {
        this.categoriesId = categoriesId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
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

    public String getImgHD() {
        return imgHD;
    }

    public void setImgHD(String imgHD) {
        this.imgHD = imgHD;
    }

    public String getImgFHD() {
        return imgFHD;
    }

    public void setImgFHD(String imgFHD) {
        this.imgFHD = imgFHD;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
