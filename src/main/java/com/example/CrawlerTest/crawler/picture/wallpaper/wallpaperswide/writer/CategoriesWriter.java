package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.writer;

import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class CategoriesWriter implements ItemWriter<Categories> {
    @Override
    public void write(List<? extends Categories> list) throws Exception {
        System.out.println();
    }
}
