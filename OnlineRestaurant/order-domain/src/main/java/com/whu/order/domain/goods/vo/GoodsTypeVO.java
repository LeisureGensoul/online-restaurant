package com.whu.order.domain.goods.vo;

import lombok.Data;

import java.util.Date;


@Data
public class GoodsTypeVO {
    private Integer id;

    private String type;

    private Date createTime;

    private Date updateTime;
}
