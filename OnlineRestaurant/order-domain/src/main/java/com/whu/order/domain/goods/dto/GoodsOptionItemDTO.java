package com.whu.order.domain.goods.dto;

import lombok.Data;

import java.util.Date;


@Data
public class GoodsOptionItemDTO {

    private Integer id;

    private String optionItem;

    private Double extraPrice;

    private Date createTime;

    private Date updateTime;
}
