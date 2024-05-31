package com.whu.order.repository.dao;

import com.whu.order.repository.entity.CartGoodsDO;

public interface CartGoodsDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CartGoodsDO record);

    int insertSelective(CartGoodsDO record);

    CartGoodsDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartGoodsDO record);

    int updateByPrimaryKey(CartGoodsDO record);
}