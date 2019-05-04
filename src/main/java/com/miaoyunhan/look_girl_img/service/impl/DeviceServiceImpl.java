package com.miaoyunhan.look_girl_img.service.impl;

import com.miaoyunhan.look_girl_img.dao.DeviceDao;
import com.miaoyunhan.look_girl_img.entity.DeviceEntity;
import com.miaoyunhan.look_girl_img.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public DeviceEntity updateDeviceInfo(String deviceId) {
        Optional<DeviceEntity> byId = deviceDao.findById(deviceId);
        if(!byId.isPresent()){
            DeviceEntity deviceEntity = new DeviceEntity(deviceId,new Date(),0);
            DeviceEntity save = deviceDao.save(deviceEntity);
            return save;
        }else{
            if (byId.get().getState() == 2 || (new Date().getTime()-(1000*60)) <= byId.get().getInitDate().getTime()){
                return byId.get();
            }else{
                DeviceEntity deviceEntity = byId.get();
                deviceEntity.setState(1);
                deviceDao.save(deviceEntity);
                return deviceEntity;
            }
        }
    }
}
