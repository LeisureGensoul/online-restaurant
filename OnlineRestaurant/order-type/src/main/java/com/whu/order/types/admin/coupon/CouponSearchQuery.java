package com.whu.order.types.admin.coupon;

import com.whu.order.types.PageQuery;
import lombok.Data;


@Data
public class CouponSearchQuery extends PageQuery {

    private String couponName;

    private Integer userType;
}
