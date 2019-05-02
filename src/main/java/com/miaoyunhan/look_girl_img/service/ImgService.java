package com.miaoyunhan.look_girl_img.service;

import com.miaoyunhan.look_girl_img.entity.ImgEntity;

import java.util.List;

public interface ImgService {
    ImgEntity save(ImgEntity imgEntity);

    List<ImgEntity> findGroupList(Integer pageNo, Integer pageSize);

    List<ImgEntity> findByGroup(String group);
}
