package com.whu.order.repository.dao;

import com.whu.order.repository.entity.UserCouponDO;
import com.whu.order.repository.entity.UserCouponDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCouponDOMapper {
    int countByExample(UserCouponDOExample example);

    int deleteByExample(UserCouponDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCouponDO record);

    int insertSelective(UserCouponDO record);

    List<UserCouponDO> selectByExample(UserCouponDOExample example);

    UserCouponDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCouponDO record, @Param("example") UserCouponDOExample example);

    int updateByExample(@Param("record") UserCouponDO record, @Param("example") UserCouponDOExample example);

    int updateByPrimaryKeySelective(UserCouponDO record);

    int updateByPrimaryKey(UserCouponDO record);
}