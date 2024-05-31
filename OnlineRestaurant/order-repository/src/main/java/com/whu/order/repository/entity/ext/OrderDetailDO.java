package com.whu.order.repository.entity.ext;

import com.whu.order.repository.entity.OrderFormDO;
import com.whu.order.repository.entity.OrderFormInfoDO;

import java.util.List;


public class OrderDetailDO extends OrderFormDO {
    private List<OrderFormInfoDO> orderFormInfoDOList;

    public List<OrderFormInfoDO> getOrderFormInfoDOList() {
        return orderFormInfoDOList;
    }

    public void setOrderFormInfoDOList(List<OrderFormInfoDO> orderFormInfoDOList) {
        this.orderFormInfoDOList = orderFormInfoDOList;
    }
}
