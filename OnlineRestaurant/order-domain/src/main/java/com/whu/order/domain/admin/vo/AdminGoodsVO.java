package com.whu.order.domain.admin.vo;

import lombok.Data;

import java.util.Date;


@Data
public class AdminGoodsVO {
    private Integer id;

    private String goodsName;

    private String description;

    private String ingredients;

    private String weight;

    private String taste;

    private String isMeat;

    private Double price;

    private Integer stock;

    private Integer sales;

    private Integer score;

    private Double cost;

    private String goodsType;

    private Date createTime;

    private Date updateTime;

}
