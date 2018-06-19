package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.processor;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriesProcessor implements ItemProcessor<Categories,Categories> {

    @Autowired
    CategoriesMapper categoriesMapper;

    @Override
    public Categories process(Categories categories) throws Exception {

        System.out.println("--------------------------------------------------------------");
        System.out.println(categories.getLevel()+"\t"+categories.getTitle()+"\t"+categories.getSrc()+"\t"+categories.getCount()+"\t"+categories.getHash());
        System.out.println("--------------------------------------------------------------");

        try {
            Integer count = categoriesMapper.selectCount(new EntityWrapper<Categories>().eq("hash",categories.getHash()));
            if(count==0) {
                categoriesMapper.insert(categories);
            }else{
                System.out.println("Wallpaperswide_Categories exists!");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return categories;
    }

}
