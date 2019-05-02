package com.miaoyunhan.look_girl_img.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "img")
public class ImgEntity {

    @Id
    private String imgUrl;

    private String title;

    private String imgGroup;

    private Integer store;

    private Integer isRoot;

    private String model;

    private String org;
}


