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
@Entity(name = "activation")
public class ActivationEntity {
    @Id
    private String no;
    private String deviceId;
    private Date createTime;
}
