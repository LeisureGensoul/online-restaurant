package com.whu.order.repository.dao;

import com.whu.order.repository.entity.GoodsOptionItemDO;
import com.whu.order.repository.entity.GoodsOptionItemDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsOptionItemDOMapper {
    int countByExample(GoodsOptionItemDOExample example);

    int deleteByExample(GoodsOptionItemDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsOptionItemDO record);

    int insertSelective(GoodsOptionItemDO record);

    List<GoodsOptionItemDO> selectByExample(GoodsOptionItemDOExample example);

    GoodsOptionItemDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsOptionItemDO record, @Param("example") GoodsOptionItemDOExample example);

    int updateByExample(@Param("record") GoodsOptionItemDO record, @Param("example") GoodsOptionItemDOExample example);

    int updateByPrimaryKeySelective(GoodsOptionItemDO record);

    int updateByPrimaryKey(GoodsOptionItemDO record);
}