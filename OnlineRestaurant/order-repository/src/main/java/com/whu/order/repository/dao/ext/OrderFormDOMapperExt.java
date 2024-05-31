package com.whu.order.repository.dao.ext;

import com.whu.order.repository.entity.ext.OrderDetailDO;

import java.util.List;


public interface OrderFormDOMapperExt {

    /**
     * 查询用户订单列表
     * @param userId 用户id
     * @return 订单列表
     */
    List<OrderDetailDO> selectOrderDetailList(Integer userId);

    List<OrderDetailDO> selectUserNoCommentsOrderList(Integer userId);
}
