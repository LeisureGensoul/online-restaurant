package com.whu.order.admin.order.converter;

import com.whu.order.domain.admin.vo.OrderFormInfoVO;
import com.whu.order.repository.entity.OrderFormInfoDO;
import com.whu.order.types.payment.DeliveryStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OrderInfoDataConverter {

    public List<OrderFormInfoVO> convertOrderInfoDO2VO(List<OrderFormInfoDO> orderFormInfoDOS) {
        List<OrderFormInfoVO> res = new ArrayList<>();
        orderFormInfoDOS.forEach(orderFormInfoDO -> {
            OrderFormInfoVO orderFormInfoVO = new OrderFormInfoVO();
            BeanUtils.copyProperties(orderFormInfoDO, orderFormInfoVO);
            orderFormInfoVO.setDeliveryStatus(DeliveryStatus.getMsgByCode(orderFormInfoDO.getDeliveryStatus()));
            res.add(orderFormInfoVO);
        });

        return res;
    }
}
