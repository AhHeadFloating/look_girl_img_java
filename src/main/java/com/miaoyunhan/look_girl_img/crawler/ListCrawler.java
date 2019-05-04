package com.miaoyunhan.look_girl_img.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Crawling news from github news
 *
 * @author hu
 */
public class ListCrawler extends BreadthCrawler {


    private static List<String> imgList= new ArrayList<>();

    public ListCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /*start pages*/
        this.addSeed("https://www.meituri.com/s/35/");
        for(int pageIndex = 1; pageIndex <= 42; pageIndex++) {
            String seedUrl = String.format("https://www.meituri.com/s/35/index_%d.html", pageIndex);
            this.addSeed(seedUrl);
        }

        /*fetch url like "https://blog.github.com/2018-07-13-graphql-for-octokit/" */
        this.addRegex("https://www.meituri.com/.*");
        this.addRegex("https://www.meituri.com/.*\\.html");

        setThreads(20);
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        String url = page.url();
        boolean contains = page.html().contains("拍摄机构");
        if(!contains){
            return;
        }

        String html = page.select(".tuji p").html();
        String[] split1 = html.split("图片数量： ");
        String[] ps = split1[1].split("P");
        String total = ps[0].trim();
        Integer integer = new Integer(total);


        /*if page is news page*/
        if (page.matchUrl("https://www.meituri.com/*/.*/")) {
            if(url.contains("html")){
                System.out.println(url);
            }

            for (int i = 2; i < integer/5; i++) {
                String nextUrl = url+i+".html";
                CrawlDatum imgPage = next.addAndReturn(nextUrl).key(nextUrl).type("imgPage");
                this.addSeed(imgPage);
                imgList.add(nextUrl);
            }
        }else if(page.matchUrl("https://www.meituri.com/*/.\\d.html")){
            System.out.println(url);
        }
        /*Elements select = page.select(".tupian_img");
        for (int i=0;true;i++){
            ImgEntity imgEntity = new ImgEntity();
            try{
                imgEntity.setImgGroup(url.split("/")[4]);
                imgEntity.setImgUrl(select.get(i).attr("src"));
            }catch (Exception e){
                break;
            }
            ImgService imgService = SpringUtil.getBean(ImgService.class);
            imgService.save(imgEntity);
        }*/

        System.out.println("URL:\n" + url);
    }

    public static void start() throws Exception {
        ListCrawler crawler = new ListCrawler("crawl", true);
        crawler.start(2);
        ObjectMapper objectMapper = new ObjectMapper();


        DemoManualNewsCrawler crawler2 = new DemoManualNewsCrawler("crawl2", true,imgList);
        crawler2.start(1);

    }

}