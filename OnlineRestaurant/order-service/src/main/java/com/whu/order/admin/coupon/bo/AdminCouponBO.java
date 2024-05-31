package com.whu.order.admin.coupon.bo;

import com.whu.order.repository.entity.CouponDO;
import com.whu.order.types.admin.coupon.CouponQuery;
import com.whu.order.types.admin.coupon.CouponSearchQuery;
import com.whu.order.types.admin.coupon.CouponUpdateQuery;

import java.util.List;


public interface AdminCouponBO {

    List<CouponDO> selectCoupons();

    CouponDO getCouponById(Integer couponId);

    int updateCoupon(CouponUpdateQuery coupon);

    int deleteCoupon(Integer couponId);

    int addCoupon(CouponQuery query);

    List<CouponDO> search(CouponSearchQuery query);

    List<CouponDO> searchByUserType(Integer userType);

    List<CouponDO> searchByName(String couponName);
}
