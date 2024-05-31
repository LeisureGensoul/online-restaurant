package com.whu.order.domain.coupon.dto;

import lombok.Data;

import java.util.Date;


@Data
public class UserCouponDTO {
    private Integer id;

    private Integer userId;

    private String couponName;

    private Double reach;

    private Double reduce;

    private Date expireTime;

}
