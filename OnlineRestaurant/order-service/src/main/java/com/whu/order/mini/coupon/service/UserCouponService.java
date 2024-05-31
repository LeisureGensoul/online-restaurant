package com.whu.order.mini.coupon.service;

import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.coupon.dto.CouponDTO;
import com.whu.order.domain.coupon.dto.UserCouponDTO;
import com.whu.order.types.PageQuery;

import java.util.List;


public interface UserCouponService {

    /**
     * 领取优惠券
     * @param userId 用户id
     * @param couponDTO 优惠券
     * @return 是否成功
     */
    boolean getCoupon(Integer userId, CouponDTO couponDTO);

    /**
     * 获取用户有效的优惠券
     *
     * @param query 分页查询
     * @param userId 用户id
     * @return 优惠券
     */
    PageResult<List<UserCouponDTO>> getValidCoupons(PageQuery query, Integer userId);

    /**
     * 获取用户失效的优惠券
     * @param query 分页请求
     * @param userId 用户id
     * @return 优惠券
     */
    PageResult<List<UserCouponDTO>> getExpireCoupons(PageQuery query, Integer userId);

    /**
     * 用户使用优惠券
     *
     * @param id     用户优惠券id
     * @param userId 用户id
     * @param totalAmount 订单总价
     * @return 使用优惠券后的金额
     */
    Double useCoupon(Integer id, Integer userId, double totalAmount);
}
