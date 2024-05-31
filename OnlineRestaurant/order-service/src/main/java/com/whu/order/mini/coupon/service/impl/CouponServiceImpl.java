package com.whu.order.mini.coupon.service.impl;

import com.whu.order.commons.result.PageResult;
import com.whu.order.mini.coupon.bo.CouponBO;
import com.whu.order.mini.coupon.service.CouponService;
import com.whu.order.domain.coupon.dto.CouponDTO;
import com.whu.order.repository.dao.ext.CouponDOMapperExt;
import com.whu.order.repository.entity.CouponDO;
import com.whu.order.types.PageQuery;
import com.whu.order.types.coupon.UserGroupEnum;
import com.whu.order.mini.user.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponBO couponBO;

    @Autowired
    private UserService userService;

    @Autowired
    private CouponDOMapperExt couponDOMapperExt;

    @Override
    public PageResult<List<CouponDTO>> getVisitorCoupons(PageQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());
        List<CouponDO> couponDOList = couponBO.selectByUserTypes(UserGroupEnum.NEW_USER.getCode());

        List<CouponDTO> couponDTOList = convert2CouponDTO(couponDOList);
        PageResult<List<CouponDTO>> pageResult = new PageResult<>(couponDTOList);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        return pageResult;
    }

    @Override
    public PageResult<List<CouponDTO>> getCoupons(PageQuery query, Integer userId) {

        UserGroupEnum userType = userService.getUserType(userId);

        List<Integer> userTypes = new ArrayList<>();
        userTypes.add(userType.getCode());
        //所有用户都可以领取'会员专享'优惠券
        if (UserGroupEnum.ALL_USER != userType) {
            userTypes.add(UserGroupEnum.ALL_USER.getCode());
        }

        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());
        List<CouponDO> couponDOList = couponBO.selectByUserTypes(userTypes);
        List<CouponDTO> couponDTOList = convert2CouponDTO(couponDOList);

        PageResult<List<CouponDTO>> pageResult = new PageResult<>(couponDTOList);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        return pageResult;
    }

    @Override
    public boolean minusCouponNumber(Integer couponId) {
        int i = couponDOMapperExt.minusCouponNumber( 1);

        return i > 0;
    }

    /**
     * 将DOList转换为DTOList
     * @param couponDOList DOList
     * @return DTOList
     */
    private List<CouponDTO> convert2CouponDTO(List<CouponDO> couponDOList){
        List<CouponDTO> couponDTOList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(couponDOList)) {
            couponDOList.forEach(couponDO -> {
                CouponDTO couponDTO = new CouponDTO();
                BeanUtils.copyProperties(couponDO, couponDTO);
                couponDTOList.add(couponDTO);
            });
        }
        return couponDTOList;
    }

}
