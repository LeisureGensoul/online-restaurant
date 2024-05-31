package com.whu.order.domain.order;

import com.whu.order.domain.payment.OrderGoods;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class OrderDetail {

    private String orderNum;

    private Integer tradeStatus;

    private Date createTime;

    private Date expireTime;

    private String queueNum;

    private Double orderAmount;

    private Double payAmount;

    private Double couponAmount;

    private String remark;

    private Integer deliveryStatus;

    private String isComment;

    private List<OrderGoods> goodsList;
}
