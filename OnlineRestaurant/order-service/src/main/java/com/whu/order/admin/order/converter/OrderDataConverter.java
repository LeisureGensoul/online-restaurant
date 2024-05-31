package com.whu.order.admin.order.converter;

import com.whu.order.admin.user.bo.AdminUserBO;
import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.admin.vo.OrderFormVO;
import com.whu.order.repository.entity.OrderFormDO;
import com.whu.order.repository.entity.UserDO;
import com.whu.order.types.payment.DeliveryStatus;
import com.whu.order.types.payment.PayStatus;
import com.whu.order.types.payment.TradeStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OrderDataConverter {

    @Autowired
    private AdminUserBO adminUserBO;

    public PageResult<List<OrderFormVO>> convertOrderPageDO2VO(PageResult<List<OrderFormDO>> pageResult) {

        List<OrderFormDO> data = pageResult.getData();
        List<OrderFormVO> orderFormVOS = new ArrayList<>();
        data.forEach(orderFormDO -> {
            OrderFormVO orderFormVO = this.convertOrderFormDO2VO(orderFormDO);
            UserDO userDO = adminUserBO.getById(orderFormDO.getUserId());
            orderFormVO.setUsername(userDO.getUsername());
            orderFormVOS.add(orderFormVO);
        });
        PageResult<List<OrderFormVO>> result = new PageResult<>();
        BeanUtils.copyProperties(pageResult, result);
        result.setData(orderFormVOS);

        return result;
    }

    public OrderFormVO convertOrderFormDO2VO(OrderFormDO orderFormDO) {

        OrderFormVO orderFormVO = new OrderFormVO();
        BeanUtils.copyProperties(orderFormDO, orderFormVO);
        orderFormVO.setTradeStatus(TradeStatus.getMsgByCode(orderFormDO.getTradeStatus()));
        orderFormVO.setPayStatus(PayStatus.getMsgByCode(orderFormDO.getPayStatus()));
        orderFormVO.setDeliveryStatus(DeliveryStatus.getMsgByCode(orderFormDO.getDeliveryStatus()));

        return orderFormVO;
    }
}
