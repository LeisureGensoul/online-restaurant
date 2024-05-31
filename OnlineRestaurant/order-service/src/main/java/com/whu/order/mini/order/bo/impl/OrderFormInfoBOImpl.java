package com.whu.order.mini.order.bo.impl;

import com.whu.order.mini.order.bo.OrderFormInfoBO;
import com.whu.order.repository.dao.OrderFormInfoDOMapper;
import com.whu.order.repository.entity.OrderFormInfoDO;
import com.whu.order.repository.entity.OrderFormInfoDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderFormInfoBOImpl implements OrderFormInfoBO {
    @Autowired
    private OrderFormInfoDOMapper orderFormInfoDOMapper;

    @Override
    public List<OrderFormInfoDO> selectByOrderNum(String orderNum) {
        OrderFormInfoDOExample orderFormInfoDOExample = new OrderFormInfoDOExample();
        orderFormInfoDOExample.createCriteria()
                .andOrderNumEqualTo(orderNum);

        List<OrderFormInfoDO> orderFormInfoDOList = orderFormInfoDOMapper.selectByExample(orderFormInfoDOExample);

        return orderFormInfoDOList;
    }
}
