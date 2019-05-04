package com.miaoyunhan.look_girl_img.service.impl;

import com.miaoyunhan.look_girl_img.dao.ActivationDao;
import com.miaoyunhan.look_girl_img.entity.ActivationEntity;
import com.miaoyunhan.look_girl_img.service.ActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivationServiceImpl implements ActivationService {

    @Autowired
    private ActivationDao activationDao;

    @Override
    public Optional<ActivationEntity> findById(String activationNo) {
        Optional<ActivationEntity> byId = activationDao.findById(activationNo);
        return byId;
    }

    @Override
    public ActivationEntity save(ActivationEntity activationEntity) {
        ActivationEntity save = activationDao.save(activationEntity);
        return save;
    }
}
