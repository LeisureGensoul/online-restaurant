package com.whu.order.mini.coupon.bo;

import com.whu.order.repository.entity.CouponDO;

import java.util.List;


public interface CouponBO {

    List<CouponDO> selectByUserTypes(Integer userType);

    List<CouponDO> selectByUserTypes(List<Integer> userTypes);

}
