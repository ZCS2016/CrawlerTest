package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.writer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.WallpaperMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Wallpaper;
import com.example.CrawlerTest.crawler.util.io.download.MultiThreadPictureDownloadService;
import com.example.CrawlerTest.crawler.util.io.download.PictureDownloadService;
import com.example.CrawlerTest.crawler.util.io.download.entity.PictureDownloadTask;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public class WallpaperWriter implements ItemWriter<Categories> {
    @Autowired
    CategoriesMapper categoriesMapper;

    @Autowired
    WallpaperMapper wallpaperMapper;

    @Autowired
    MultiThreadPictureDownloadService multiThreadPictureDownloadService;

    @Value("${crawler.downloadDir}")
    private String downloadDir;

    @Override
    public void write(List<? extends Categories> categoriesList) throws Exception {
        for (Categories categories : categoriesList) {
            Integer count = 0;
            for (Wallpaper childrenWallpaper : categories.getChildrenWallpapers()) {
                try {
                    Integer existCount = wallpaperMapper.selectCount(new EntityWrapper<Wallpaper>().eq("hash", childrenWallpaper.getHash()));
                    if (existCount == 0) {
                        wallpaperMapper.insert(childrenWallpaper);
                        count++;

                        //Download HD img
                        File downloadDirFile = new File(downloadDir);
                        if(!downloadDirFile.exists()){
                            downloadDirFile.mkdirs();
                        }

                        PictureDownloadTask pictureDownloadTask = new PictureDownloadTask();
                        pictureDownloadTask.setUrlStr(childrenWallpaper.getImgFHD());
                        pictureDownloadTask.setFileName(childrenWallpaper.getHash()+"-FHD.jpg");
                        pictureDownloadTask.setLocalDir(downloadDir);
                        multiThreadPictureDownloadService.addPictureDownloadTask(pictureDownloadTask);
                    } else {
                        System.out.println("Wallpaperswide_Wallpaper" + childrenWallpaper.getTitle() + "exists!");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////
            //Update categories.count
            synchronized (this) {
                Categories rootCategories = categoriesMapper.selectById(categories.getId());
                rootCategories.setCount(rootCategories.getCount() + count);
                rootCategories.setCurrent(rootCategories.getCurrent() + 1);
                if (rootCategories.getCurrent() == rootCategories.getTotal()) {
                    rootCategories.setStatus("Complete");
                    rootCategories.setRunning(false);
                    rootCategories.setEndTime(LocalDateTime.now());
                }
                rootCategories.setLastUpdate(LocalDateTime.now());
                categoriesMapper.updateById(rootCategories);
                System.out.println(Thread.currentThread().getName()+"\t write: \t"+categories.getId()+"\t page: \t"+categories.getCurrent()+"\t size: \t"+count+"/"+rootCategories.getCount());
            }
            ///////////////////////////////////////////////////////////////////////////////////
            }
    }

}
