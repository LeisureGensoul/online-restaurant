package com.whu.order.types.payment;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class PayQuery {

    /**
     * 是否支付
     */
    private boolean paid;

    /**
     * 订单号
     */
    @NotBlank
    private String orderNum;
}
