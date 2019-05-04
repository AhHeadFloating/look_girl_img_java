package com.miaoyunhan.look_girl_img.service;

import com.miaoyunhan.look_girl_img.entity.DeviceEntity;

import java.util.HashMap;

public interface DeviceService {
    DeviceEntity updateDeviceInfo(String deviceId);

    HashMap<String, Object> activation(String deviceId, String activationNo);
}
