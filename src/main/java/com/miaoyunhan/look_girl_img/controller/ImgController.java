package com.miaoyunhan.look_girl_img.controller;

import com.miaoyunhan.look_girl_img.entity.ImgEntity;
import com.miaoyunhan.look_girl_img.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "img")
public class ImgController {

    @Autowired
    private ImgService imgService;

    @RequestMapping("findGroupList")
    public Object findGroupList(){
        List<ImgEntity> imgEntityList = imgService.findGroupList(1,10);
        return imgEntityList;
    }

    @RequestMapping(value = "findByGroup")
    public Object findByGroup(String group){
        List<ImgEntity> imgEntityList = imgService.findByGroup(group);
        return imgEntityList;
    }
}
