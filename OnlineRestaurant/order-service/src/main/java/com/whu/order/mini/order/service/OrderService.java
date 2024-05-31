package com.whu.order.mini.order.service;

import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.order.OrderDetail;
import com.whu.order.types.PageQuery;

import java.util.List;


public interface OrderService {

    /**
     * 获取订单详情
     *
     * @param orderNum 订单号
     * @param userId 用户id
     * @return 订单详情
     */
    OrderDetail getOrderDetail(String orderNum, Integer userId);

    /**
     * 获取用户订单列表
     *
     * @param pageQuery 分页请求
     * @param userId 用户id
     * @return 订单列表
     */
    PageResult<List<OrderDetail>> getOrderList(PageQuery pageQuery, Integer userId);

    /**
     * 获取用户未评论订单
     * @param pageQuery 分页请求
     * @param userId 用户id
     * @return 订单列表
     */
    PageResult<List<OrderDetail>> getNoCommentsOrderList(PageQuery pageQuery, Integer userId);

    /**
     * 取消交易
     * @param orderNum 根据订单号取消订单
     * @param userId 用户id
     * @return
     */
    boolean cancelOrder(String orderNum, Integer userId);
}
