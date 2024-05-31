package com.whu.order.mini.user.service;

import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.coupon.dto.UserCouponDTO;
import com.whu.order.domain.user.dto.UserDTO;
import com.whu.order.types.PageQuery;
import com.whu.order.types.coupon.UserGroupEnum;

import java.util.List;


public interface UserService {

    UserDTO selectUserByUsername(String username);

    UserDTO selectUserByOpenId(String openId);

    /**
     * 获取用户类型
     * @param userId 用户id
     * @return 用户类型
     */
    UserGroupEnum getUserType(Integer userId);

    /**
     * 用户获取优惠券
     * @param userId 用户id
     * @param couponId 优惠券id
     * @return
     */
    boolean getCoupon(Integer userId, Integer couponId);

    /**
     * 获取用户能使用的优惠券
     * @param userId 用户id
     * @return 优惠券
     */
    PageResult<List<UserCouponDTO>> getAvailableCoupons(PageQuery query, Integer userId);

    /**
     * 获取用户失效的优惠券
     * @param userId 用户id
     * @param query 分页请求
     * @return 优惠券
     */
    PageResult<List<UserCouponDTO>> getExpireCoupons(PageQuery query, Integer userId);


}
