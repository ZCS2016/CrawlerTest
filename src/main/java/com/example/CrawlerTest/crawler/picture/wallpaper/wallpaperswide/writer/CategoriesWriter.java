package com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.writer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.dao.CategoriesMapper;
import com.example.CrawlerTest.crawler.picture.wallpaper.wallpaperswide.entity.Categories;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoriesWriter implements ItemWriter<Categories> {

    @Autowired
    CategoriesMapper categoriesMapper;

    @Override
    public void write(List<? extends Categories> categoriesList) throws Exception {
//        synchronized (categoriesList) {
            for (Categories categories : categoriesList) {

                System.out.println(Thread.currentThread().getName()+"\t write: \t"+categories.getId());

                for (Categories childrenCategories : categories.getChildrenCategories()) {
//                    System.out.println("--------------------------------------------------------------");
//                    System.out.println(childrenCategories.getLevel() + "\t" + childrenCategories.getTitle() + "\t" + childrenCategories.getSrc() + "\t" + childrenCategories.getCount() + "\t" + childrenCategories.getHash());

                    try {
                        Integer count = categoriesMapper.selectCount(new EntityWrapper<Categories>().eq("hash", childrenCategories.getHash()));
                        if (count == 0) {
                            categoriesMapper.insert(childrenCategories);
                        } else {
                            System.out.println("Wallpaperswide_Categories exists!");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

//                    System.out.println("--------------------------------------------------------------");
                }
            }
//        }
    }

}
