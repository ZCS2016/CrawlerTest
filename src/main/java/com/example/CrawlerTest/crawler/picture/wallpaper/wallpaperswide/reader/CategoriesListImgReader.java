package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.reader;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler.CategoriesListCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.crawler.CategoriesListImgCrawler;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoriesListImgReader implements ItemReader<Categories> {

    @Autowired
    CategoriesListImgCrawler categoriesListImgCrawler;

    @Autowired
    CategoriesMapper categoriesMapper;

    private int count = 0;
    private List<Categories> categoriesList = new ArrayList<>();

    @Override
    public Categories read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(categoriesList.isEmpty()){
            List<Categories> categories = categoriesMapper.selectList(
                    new EntityWrapper<Categories>().eq("level","1").isNull("img")
            );
            categoriesList.addAll(categoriesListImgCrawler.getCategoriesListImg(categories));
        }

        if(!categoriesList.isEmpty()&&count<categoriesList.size()){
            return categoriesList.get(count++);
        }else{
            return null;
        }
    }
}
