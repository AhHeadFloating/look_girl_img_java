package com.miaoyunhan.look_girl_img.crawler;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleiumCrawler {

    private static ChromeDriver browser;
    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.bin","D:\\software\\Mozilla Firefox\\firefox.exe");
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
