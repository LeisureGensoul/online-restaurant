package com.whu.order.domain.payment;

import lombok.Data;


@Data
public class Order {

    private String orderNum;

    private double orderAmount;

    private double payAmount;
}
