package com.whu.order.domain.picture.dto;

import lombok.Data;

import java.util.Date;


@Data
public class PictureDTO {

    private Integer id;

    private String picName;

    private String picUrl;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    private String base64Data;
}
