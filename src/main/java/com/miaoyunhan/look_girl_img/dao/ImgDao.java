package com.miaoyunhan.look_girl_img.dao;

import com.miaoyunhan.look_girl_img.entity.ImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgDao extends JpaRepository<ImgEntity,Integer> {

    @Query(value = "select * from img group by imgGroup",nativeQuery = true)
    List<ImgEntity> findGroupList();

    List<ImgEntity> findByImgGroup(String group);
}
