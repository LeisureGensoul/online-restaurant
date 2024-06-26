package com.whu.order.domain.coupon.dto;

import lombok.Data;

import java.util.Date;


@Data
public class CouponDTO {
    private Integer id;

    private Double reach;

    private Double reduce;

    /**
     * 此处改为string类型，将优惠券使用群体id转化为字符串
     */
    private String couponName;

    private Integer effectiveTime;

    private Date deadline;

    private Integer number;

}
