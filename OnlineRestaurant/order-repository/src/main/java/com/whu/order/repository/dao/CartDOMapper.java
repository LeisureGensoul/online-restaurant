package com.whu.order.repository.dao;

import com.whu.order.repository.entity.CartDO;

public interface CartDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CartDO record);

    int insertSelective(CartDO record);

    CartDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartDO record);

    int updateByPrimaryKey(CartDO record);
}