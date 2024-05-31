package com.whu.order.types.admin.coupon;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


@Data
public class CouponUpdateQuery {

    @NotNull
    private Integer id;

    @NotNull
    private String couponName;

    @NotNull
    @Range(min = 0)
    private Integer number;

}
