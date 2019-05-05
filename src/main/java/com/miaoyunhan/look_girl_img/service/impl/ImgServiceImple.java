package com.miaoyunhan.look_girl_img.service.impl;

import com.miaoyunhan.look_girl_img.dao.ImgDao;
import com.miaoyunhan.look_girl_img.entity.ImgEntity;
import com.miaoyunhan.look_girl_img.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImple implements ImgService {

    @Autowired
    private ImgDao imgDao;

    @Override
    public ImgEntity save(ImgEntity imgEntity) {
        ImgEntity save = imgDao.save(imgEntity);
        return save;
    }

    @Override
    public List<ImgEntity> findGroupList(Integer pageNo, Integer pageSize) {
        List<ImgEntity> imgEntityList = imgDao.findGroupList();
        return imgEntityList;
    }

    @Override
    public List<ImgEntity> findByGroup(String group) {
        return imgDao.findByImgGroupSort(group);
    }
}
