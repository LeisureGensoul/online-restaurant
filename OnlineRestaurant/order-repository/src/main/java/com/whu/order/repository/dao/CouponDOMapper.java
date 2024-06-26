package com.whu.order.repository.dao;

import com.whu.order.repository.entity.CouponDOExample;
import com.whu.order.repository.entity.CouponDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponDOMapper {
    int countByExample(CouponDOExample example);

    int deleteByExample(CouponDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponDO record);

    int insertSelective(CouponDO record);

    List<CouponDO> selectByExample(CouponDOExample example);

    CouponDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponDO record, @Param("example") CouponDOExample example);

    int updateByExample(@Param("record") CouponDO record, @Param("example") CouponDOExample example);

    int updateByPrimaryKeySelective(CouponDO record);

    int updateByPrimaryKey(CouponDO record);
}