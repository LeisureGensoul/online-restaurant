package com.whu.order.domain.payment;

import lombok.Data;


@Data
public class OrderGoods {
    private Integer goodsId;

    private String goodsPic;

    private String goodsName;

    private double goodsPrice;

    private int goodsQuantity;

    private double extraPrice;

    private String extraOptions;

}
