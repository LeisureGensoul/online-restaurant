package com.whu.order.admin.order.bo;

import com.whu.order.repository.entity.OrderFormInfoDO;

import java.util.Date;
import java.util.List;


public interface AdminOrderFormInfoBO {

    OrderFormInfoDO getById(Integer id);

    List<OrderFormInfoDO> getByOrderNum(String orderNum);

    int updateByIdSelective(OrderFormInfoDO orderFormInfoDO);

    int updateByOrderNumSelective(String orderNum, OrderFormInfoDO orderFormInfoDO);

    /**
     * 得到过去date至今的订单详情
     * @param date 时间
     * @return 订单详情
     */
    List<OrderFormInfoDO> getOrderInfoBeforeDate(Date date);

    /**
     * 得到订单集合的订单详情
     * @param orderNumList 订单集合
     * @return 订单详情
     */
    List<OrderFormInfoDO> getOrderInfoOrderNumIn(List<String> orderNumList);
}
