package com.whu.order.admin.order.bo.impl;

import com.whu.order.admin.order.bo.AdminOrderFormInfoBO;
import com.whu.order.repository.dao.OrderFormInfoDOMapper;
import com.whu.order.repository.entity.OrderFormInfoDO;
import com.whu.order.repository.entity.OrderFormInfoDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class AdminOrderFormInfoBOImpl implements AdminOrderFormInfoBO {

    @Autowired
    private OrderFormInfoDOMapper orderFormInfoDOMapper;

    @Override
    public OrderFormInfoDO getById(Integer id) {
        return orderFormInfoDOMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OrderFormInfoDO> getByOrderNum(String orderNum) {
        OrderFormInfoDOExample example = new OrderFormInfoDOExample();
        example.createCriteria()
                .andOrderNumEqualTo(orderNum);

        return orderFormInfoDOMapper.selectByExample(example);
    }

    @Override
    public int updateByIdSelective(OrderFormInfoDO orderFormInfoDO) {
        return orderFormInfoDOMapper.updateByPrimaryKeySelective(orderFormInfoDO);
    }

    @Override
    public int updateByOrderNumSelective(String orderNum, OrderFormInfoDO orderFormInfoDO) {
        OrderFormInfoDOExample example = new OrderFormInfoDOExample();
        example.createCriteria()
                .andOrderNumEqualTo(orderNum);
        orderFormInfoDO.setUpdateTime(new Date());
        return orderFormInfoDOMapper.updateByExampleSelective(orderFormInfoDO, example);
    }

    @Override
    public List<OrderFormInfoDO> getOrderInfoBeforeDate(Date date) {
        OrderFormInfoDOExample example = new OrderFormInfoDOExample();
        example.createCriteria()
                .andCreateTimeGreaterThan(date);

        return orderFormInfoDOMapper.selectByExample(example);
    }

    @Override
    public List<OrderFormInfoDO> getOrderInfoOrderNumIn(List<String> orderNumList) {
        OrderFormInfoDOExample example = new OrderFormInfoDOExample();
        example.createCriteria()
                .andOrderNumIn(orderNumList);

        return orderFormInfoDOMapper.selectByExample(example);
    }

}
