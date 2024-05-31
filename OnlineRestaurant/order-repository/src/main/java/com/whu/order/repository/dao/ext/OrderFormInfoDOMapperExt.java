package com.whu.order.repository.dao.ext;

import com.whu.order.repository.entity.OrderFormInfoDO;

import java.util.List;


public interface OrderFormInfoDOMapperExt {

    List<OrderFormInfoDO> selectByOrderNum(String orderNum);
}
