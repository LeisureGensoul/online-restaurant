package com.whu.order.domain.admin.vo;

import lombok.Data;


@Data
public class OrderFormInfoVO {

    private Integer id;

    private String orderNum;

    private String goodsName;

    private Double goodsPrice;

    private Integer goodsQuantity;

    private String extraOptions;

    private String deliveryStatus;
}
