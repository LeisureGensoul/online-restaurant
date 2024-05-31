package com.whu.order.repository.dao;

import com.whu.order.repository.entity.OrderFormInfoDO;
import com.whu.order.repository.entity.OrderFormInfoDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderFormInfoDOMapper {
    int countByExample(OrderFormInfoDOExample example);

    int deleteByExample(OrderFormInfoDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderFormInfoDO record);

    int insertSelective(OrderFormInfoDO record);

    List<OrderFormInfoDO> selectByExample(OrderFormInfoDOExample example);

    OrderFormInfoDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderFormInfoDO record, @Param("example") OrderFormInfoDOExample example);

    int updateByExample(@Param("record") OrderFormInfoDO record, @Param("example") OrderFormInfoDOExample example);

    int updateByPrimaryKeySelective(OrderFormInfoDO record);

    int updateByPrimaryKey(OrderFormInfoDO record);
}