package com.miaoyunhan.look_girl_img.service.impl;

import com.miaoyunhan.look_girl_img.dao.DeviceDao;
import com.miaoyunhan.look_girl_img.entity.ActivationEntity;
import com.miaoyunhan.look_girl_img.entity.DeviceEntity;
import com.miaoyunhan.look_girl_img.service.ActivationService;
import com.miaoyunhan.look_girl_img.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private ActivationService activationService;

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

    @Override
    @Transactional
    public HashMap<String, Object> activation(String deviceId, String activationNo) {

        Optional<ActivationEntity> byId = activationService.findById(activationNo);
        Optional<DeviceEntity> byId1 = deviceDao.findById(deviceId);

        HashMap<String, Object> map = new HashMap<>();
        if(!byId.isPresent() || !byId1.isPresent()){
            map.put("status","error");
        }else{
            if(byId.get().getDeviceId() != null && !"".equals(byId.get().getDeviceId())){
                map.put("status","error");
            }else{
                ActivationEntity activationEntity = byId.get();
                activationEntity.setDeviceId(deviceId);
                ActivationEntity activationSave = activationService.save(activationEntity);

                DeviceEntity deviceEntity = byId1.get();
                deviceEntity.setState(2);
                DeviceEntity save = deviceDao.save(deviceEntity);

                map.put("status","success");
            }

        }
        return map;
    }
}
