package com.miaoyunhan.look_girl_img.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "device")
public class DeviceEntity {
    @Id
    private String deviceId;
    private Date initDate;
    private Integer State;
}
