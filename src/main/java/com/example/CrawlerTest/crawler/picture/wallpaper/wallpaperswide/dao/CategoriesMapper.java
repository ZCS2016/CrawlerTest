package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public interface CategoriesMapper extends BaseMapper<Categories> {

}
