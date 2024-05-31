package com.whu.order.domain.goods.dto;

import lombok.Data;

import java.util.Date;


@Data
public class GoodsTypeDTO {

    private Integer id;

    private String type;

    private Date createTime;

    private Date updateTime;
}
