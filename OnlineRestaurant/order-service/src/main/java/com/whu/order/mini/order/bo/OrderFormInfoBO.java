package com.whu.order.mini.order.bo;

import com.whu.order.repository.entity.OrderFormInfoDO;

import java.util.List;


public interface OrderFormInfoBO {

    /**
     * 根据订单号查询订单详情
     * @param orderNum 订单号
     * @return 订单详情
     */
    List<OrderFormInfoDO> selectByOrderNum(String orderNum);
}
