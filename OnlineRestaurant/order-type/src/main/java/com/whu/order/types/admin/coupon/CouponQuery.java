package com.whu.order.types.admin.coupon;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class CouponQuery {

    @NotBlank
    private String couponName;

    @NotNull
    private Double reach;

    @NotNull
    private Double reduce;

    @NotNull
    private Integer userType;

    @NotNull
    private Integer effectiveTime;

    @NotNull
    private Date deadline;

    @NotNull
    private Integer number;
}
