package com.whu.order.admin.order.service;

import com.whu.order.commons.result.PageResult;
import com.whu.order.repository.entity.OrderFormDO;
import com.whu.order.types.PageQuery;
import com.whu.order.types.admin.order.OrderSearchQuery;

import java.util.List;


public interface AdminOrderService {

    PageResult<List<OrderFormDO>> getAllOrders(PageQuery query);

    PageResult<List<OrderFormDO>> getUndononlinerestaurants(PageQuery query);

    boolean deliveryOne(Integer orderInfoId);

    boolean deliveryAll(String orderNum);

    PageResult<List<OrderFormDO>> search(OrderSearchQuery query);
}
