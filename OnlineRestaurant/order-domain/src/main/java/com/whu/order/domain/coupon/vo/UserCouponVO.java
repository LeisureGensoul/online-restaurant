package com.whu.order.domain.coupon.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class UserCouponVO {
    private Integer id;

    private String couponName;

    private Double reach;

    private Double reduce;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date expireTime;
}
