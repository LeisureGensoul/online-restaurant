package com.whu.order.mini.payment;


import com.whu.order.domain.payment.Order;
import com.whu.order.domain.payment.PayInfo;


public class WeChatPayment {

    /**
     * 下单预支付
     * @param order 订单
     * @return 预支付信息
     */
    public static PayInfo pronlinerestaurant(Order order){

        return new PayInfo(order);
    }

    /**
     * 支付mock方法
     * @param order 订单
     * @return 支付结果
     */
    public static boolean pay(PayInfo order){
        return true;
    }
}
