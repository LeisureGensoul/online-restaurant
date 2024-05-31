package com.whu.order.mini.user.service.impl;

import com.whu.order.commons.result.PageResult;
import com.whu.order.commons.utils.DateUtils;
import com.whu.order.mini.coupon.service.CouponService;
import com.whu.order.mini.coupon.service.UserCouponService;
import com.whu.order.domain.coupon.dto.CouponDTO;
import com.whu.order.domain.coupon.dto.UserCouponDTO;
import com.whu.order.domain.user.dto.UserDTO;
import com.whu.order.mini.user.service.UserService;
import com.whu.order.repository.dao.CouponDOMapper;
import com.whu.order.repository.dao.UserDOMapper;
import com.whu.order.repository.dao.ext.UserDOMapperExt;
import com.whu.order.repository.entity.CouponDO;
import com.whu.order.repository.entity.UserDO;
import com.whu.order.types.PageQuery;
import com.whu.order.types.coupon.UserGroupEnum;
import com.whu.order.types.exception.BusinessException;
import com.whu.order.types.exception.ErrorType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private UserDOMapperExt userDOMapperExt;

    @Autowired
    private CouponService couponService;

    @Autowired
    private UserCouponService userCouponService;

    @Autowired
    private CouponDOMapper couponDOMapper;

    @Override
    public UserDTO selectUserByUsername(String username) {
        UserDO userDO = userDOMapperExt.selectByUsername(username);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);

        return userDTO;
    }

    @Override
    public UserDTO selectUserByOpenId(String openId) {
        UserDO userDO = userDOMapperExt.selectByOpenId(openId);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);

        return userDTO;
    }

    @Override
    public UserGroupEnum getUserType(Integer userId){
        UserDO userDO = userDOMapper.selectByPrimaryKey(userId);

        Date createTime = userDO.getCreateTime();
        //创建时间加上3天
        Date latestTime = DateUtils.add(createTime, Calendar.DATE, 3);
        Date now = new Date();
        if (now.before(latestTime)) {
            return UserGroupEnum.NEW_USER;
        }

        //是否是老用户
        Date afterYear = DateUtils.add(createTime, Calendar.YEAR, 1);
        if (now.after(afterYear)) {
            return UserGroupEnum.OLD_USER;
        }
        return UserGroupEnum.ALL_USER;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean getCoupon(Integer userId, Integer couponId) {

        //判断用户是否能领取
        CouponDO couponDO = couponDOMapper.selectByPrimaryKey(couponId);
        UserGroupEnum userType = this.getUserType(userId);

        Integer couponUserType = couponDO.getUserType();
        //用户不能领取
        if (!couponUserType.equals(UserGroupEnum.ALL_USER.getCode()) && !couponUserType.equals(userType.getCode())) {
            throw new BusinessException(ErrorType.PARAM_USER_AUTH, "用户不能领取");
        }

        CouponDTO coupon = new CouponDTO();
        BeanUtils.copyProperties(couponDO, coupon);
        //优惠券是否超过截止时间
        boolean isOutOfDeadline = coupon.getDeadline().before(new Date());
        //是否已经无法领取
        if (coupon.getNumber() <= 0 || isOutOfDeadline) {
            throw new BusinessException(ErrorType.PARAM_USER_AUTH, "优惠券已领完");
        }

        //领取优惠券
        //优惠券数量减一、加入用户优惠券表、设置优惠券过期时间
        couponService.minusCouponNumber(coupon.getId());
        userCouponService.getCoupon(userId, coupon);

        return true;
    }

    @Override
    public PageResult<List<UserCouponDTO>> getAvailableCoupons(PageQuery query, Integer userId) {
        PageResult<List<UserCouponDTO>> validCoupons = userCouponService.getValidCoupons(query, userId);
        return validCoupons;
    }

    @Override
    public PageResult<List<UserCouponDTO>> getExpireCoupons(PageQuery query, Integer userId) {
        PageResult<List<UserCouponDTO>> expireCoupons = userCouponService.getExpireCoupons(query, userId);
        return expireCoupons;
    }

}
