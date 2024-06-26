package com.whu.order.mini.coupon.bo.impl;

import com.whu.order.mini.coupon.bo.CouponBO;
import com.whu.order.repository.dao.CouponDOMapper;
import com.whu.order.repository.entity.CouponDO;
import com.whu.order.repository.entity.CouponDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class CouponBOImpl implements CouponBO {

    @Autowired
    private CouponDOMapper couponDOMapper;

    @Override
    public List<CouponDO> selectByUserTypes(Integer userType) {
        CouponDOExample example = new CouponDOExample();
        example.createCriteria()
                .andDeadlineGreaterThan(new Date())
                .andUserTypeEqualTo(userType)
                .andIsDeleteEqualTo("n");
        return couponDOMapper.selectByExample(example);
    }

    @Override
    public List<CouponDO> selectByUserTypes(List<Integer> userTypes) {
        CouponDOExample example = new CouponDOExample();
        example.setOrderByClause("user_type desc,reach");
        example.createCriteria()
                .andDeadlineGreaterThan(new Date())
                .andUserTypeIn(userTypes)
                .andIsDeleteEqualTo("n");

        return couponDOMapper.selectByExample(example);
    }
}
