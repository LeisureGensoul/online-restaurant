package com.whu.order.admin.coupon.service;

import com.whu.order.commons.result.PageResult;
import com.whu.order.repository.entity.CouponDO;
import com.whu.order.types.PageQuery;
import com.whu.order.types.admin.coupon.CouponSearchQuery;

import java.util.List;


public interface AdminCouponService {

    PageResult<List<CouponDO>> getCouponList(PageQuery query);

    PageResult<List<CouponDO>> searchCoupon(CouponSearchQuery query);
}
