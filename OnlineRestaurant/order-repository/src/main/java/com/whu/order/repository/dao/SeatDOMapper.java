package com.whu.order.repository.dao;

import com.whu.order.repository.entity.SeatDO;

public interface SeatDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeatDO record);

    int insertSelective(SeatDO record);

    SeatDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeatDO record);

    int updateByPrimaryKey(SeatDO record);
}