package com.miaoyunhan.look_girl_img;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miaoyunhan.look_girl_img.crawler.ListCrawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LookGirlImgApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void init() throws Exception {
        /*ListCrawler crawler = new ListCrawler("crawl", true);
        *//*start crawl with depth of 4*//*
        crawler.start(2);
        ObjectMapper objectMapper = new ObjectMapper();*/
        ListCrawler.start();
    }
}
