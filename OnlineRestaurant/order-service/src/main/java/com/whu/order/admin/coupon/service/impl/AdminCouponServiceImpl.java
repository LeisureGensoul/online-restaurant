package com.whu.order.admin.coupon.service.impl;

import com.whu.order.admin.coupon.bo.AdminCouponBO;
import com.whu.order.admin.coupon.service.AdminCouponService;
import com.whu.order.commons.result.PageResult;
import com.whu.order.repository.entity.CouponDO;
import com.whu.order.types.PageQuery;
import com.whu.order.types.admin.coupon.CouponSearchQuery;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminCouponServiceImpl implements AdminCouponService {

    @Autowired
    private AdminCouponBO adminCouponBO;

    @Override
    public PageResult<List<CouponDO>> getCouponList(PageQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());

        List<CouponDO> couponDOS = adminCouponBO.selectCoupons();

        PageResult<List<CouponDO>> pageResult = new PageResult<>(couponDOS);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        return pageResult;
    }

    @Override
    public PageResult<List<CouponDO>> searchCoupon(CouponSearchQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());

        List<CouponDO> couponDOS = adminCouponBO.search(query);

        PageResult<List<CouponDO>> pageResult = new PageResult<>(couponDOS);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        return pageResult;
    }
}
