package com.miaoyunhan.look_girl_img;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(value = "com.miaoyunhan.look_girl_img.entity")
@ComponentScan(value = "com.miaoyunhan")
public class LookGirlImgApplication {

    public static void main(String[] args) {
        SpringApplication.run(LookGirlImgApplication.class, args);
    }

}
