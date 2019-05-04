package com.miaoyunhan.look_girl_img.service;

import com.miaoyunhan.look_girl_img.entity.ActivationEntity;

import java.util.Optional;

public interface ActivationService {

    Optional<ActivationEntity> findById(String activationNo);

    ActivationEntity save(ActivationEntity activationEntity);
}
