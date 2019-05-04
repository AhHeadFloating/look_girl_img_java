package com.miaoyunhan.look_girl_img.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;
import com.miaoyunhan.look_girl_img.entity.ImgEntity;
import com.miaoyunhan.look_girl_img.service.ImgService;
import com.miaoyunhan.look_girl_img.utils.SpringUtil;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Crawling news from github news
 *
 * @author hu
 */
public class DemoManualNewsCrawler extends BreadthCrawler {

    public DemoManualNewsCrawler(String crawlPath, boolean autoParse, List<String> imgList) {
        super(crawlPath, autoParse);

        this.addSeed(imgList);
        this.addRegex(".*");

        setThreads(50);
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        String url = page.url();
        boolean contains = page.html().contains("拍摄机构");
        if(!contains){
            return;
        }

        if (page.matchUrl("https://www.meituri.com/*/.*/")) {
            System.out.println("第一页");
        }else if(page.matchUrl("https://www.meituri.com/*/.\\d.html")){
            System.out.println("不是第一页");
        }
        Elements select = page.select(".tupian_img");
        for (int i=0;true;i++){
            ImgEntity imgEntity = new ImgEntity();
            try{
                imgEntity.setImgGroup(url.split("/")[4]);
                String imgurl = select.get(i).attr("src");
                imgEntity.setImgUrl(imgurl);

                String[] imgSplit = imgurl.split("/");
                String fileName = imgSplit[imgSplit.length-1];
                String[] split = fileName.split("\\.");
                String store = split[0];
                imgEntity.setStore(Integer.parseInt(store));
            }catch (Exception e){
                break;
            }
            ImgService imgService = SpringUtil.getBean(ImgService.class);
            imgService.save(imgEntity);
        }
        System.out.println(page.url());
    }


    public static void main(String[] args) {
        String str = "https://www.meituri.com/a/1011/9.html";

        String[] imgSplit = str.split("/");
        String fileName = imgSplit[imgSplit.length-1];
        String[] split = fileName.split("\\.");
        String store = split[0];
        System.out.println(store);
    }
}

