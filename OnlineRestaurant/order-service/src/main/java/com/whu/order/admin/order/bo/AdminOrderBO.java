package com.whu.order.admin.order.bo;

import com.whu.order.repository.entity.OrderFormDO;
import com.whu.order.types.PageQuery;
import com.whu.order.types.admin.order.OrderSearchQuery;

import java.util.Date;
import java.util.List;


public interface AdminOrderBO {

    List<OrderFormDO> getAllOrders(PageQuery query);

    List<OrderFormDO> getUndononlinerestaurants(PageQuery query);

    int updatonlinerestaurantFormByOrderNum(String orderNum, OrderFormDO orderFormDO);

    List<OrderFormDO> getByOrderNum(String orderNum);

    List<OrderFormDO> search(OrderSearchQuery query);

    /**
     * 指定时间前的订单
     * @param date 时间
     * @return 订单list
     */
    List<OrderFormDO> getOrderBeforeDate(Date date);
}
