package com.whu.order.mini.order.bo;

import com.whu.order.repository.entity.OrderFormDO;

import java.util.List;


public interface OrderFormBO {

    /**
     * 根据订单号查询订单
     * @param orderNum 订单号
     * @return 订单
     */
    OrderFormDO selectByOrderNum(String orderNum);

    /**
     * 根据订单号修改
     * @param orderFormDO 订单DO
     * @param orderNum 订单号
     * @return i
     */
    int updateByOrderNumSelective(OrderFormDO orderFormDO, String orderNum);

    /**
     * 查询已失效的订单
     * @return 订单
     */
    List<OrderFormDO> selectExpiredOrderForm();
}
