package com.whu.order.domain.coupon.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class CouponVO {

    private Integer id;

    private Double reach;

    private Double reduce;

    private String couponName;

    private Integer effectiveTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date deadline;

}
