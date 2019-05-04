package com.miaoyunhan.look_girl_img.dao;

import com.miaoyunhan.look_girl_img.entity.ActivationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface ActivationDao extends JpaRepository<ActivationEntity,String> {
}
