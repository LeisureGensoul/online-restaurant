package com.whu.order.domain.payment;

import lombok.Data;


@Data
public class PayInfo {
    private Order order;

    public PayInfo(Order order) {
        this.order = order;
    }
}
