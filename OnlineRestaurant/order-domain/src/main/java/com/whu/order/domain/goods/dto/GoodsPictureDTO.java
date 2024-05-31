package com.whu.order.domain.goods.dto;

import lombok.Data;

import java.util.Date;


@Data
public class GoodsPictureDTO {

    private Integer id;

    private Integer goodsId;

    private String picUrl;

    private String picName;

    private Date createTime;

    private Date updateTime;
}
