package com.example.CrawlerTest.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.CrawlerTest.web.entity.CrawlerJob;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public interface CrawlerJobMapper extends BaseMapper<CrawlerJob> {
}
