package com.miaoyunhan.look_girl_img.controller;

import com.miaoyunhan.look_girl_img.entity.DeviceEntity;
import com.miaoyunhan.look_girl_img.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "project")
public class ProjectController {
    @Autowired
    private DeviceService deviceService;

    @RequestMapping("updateDevice")
    public DeviceEntity updateDeviceInfo(String deviceId){
        DeviceEntity deviceEntity = deviceService.updateDeviceInfo(deviceId);
        return deviceEntity;
    }
}
