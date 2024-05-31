package com.whu.order.domain.order.dto;

import lombok.Data;

import java.util.Date;


@Data
public class OrderFormDTO {

    private String orderNum;

    private Integer tradeStatus;

    private Integer payStatus;

    private Date createTime;

    private Date closeTime;

    private String remark;

    private Double orderAmount;

    private Double payAmount;

}
