package com.whu.order.mini.payment;

import com.whu.order.domain.payment.Order;
import com.whu.order.types.payment.PayQuery;
import com.whu.order.types.payment.PrePayQuery;


public interface PaymentService {

    /**
     * 创建订单
     * @param prePayQuery 支付请求
     * @param userId 用户id
     * @return 订单
     */
    Order creatonlinerestaurant(PrePayQuery prePayQuery, Integer userId);

    /**
     *
     * @param payQuery
     * @param userId
     * @return
     */
    boolean pay(PayQuery payQuery, Integer userId);
}
