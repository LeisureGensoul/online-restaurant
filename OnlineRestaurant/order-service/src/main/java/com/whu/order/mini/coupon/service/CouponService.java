package com.whu.order.mini.coupon.service;

import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.coupon.dto.CouponDTO;
import com.whu.order.types.PageQuery;

import java.util.List;


public interface CouponService {

    /**
     * 访客查询优惠券，返回新用户优惠券
     *
     * @return 优惠券
     */
    PageResult<List<CouponDTO>> getVisitorCoupons(PageQuery query);

    /**
     * 查询改用户能领取的优惠券
     *
     * @param query 分页查询
     * @param userId 用户id
     * @return 优惠券列表页
     */
    PageResult<List<CouponDTO>> getCoupons(PageQuery query, Integer userId);

    /**
     * 减少优惠券数量1
     *
     * @param couponId 优惠券id
     * @return 是否成功
     */
    boolean minusCouponNumber(Integer couponId);
}
