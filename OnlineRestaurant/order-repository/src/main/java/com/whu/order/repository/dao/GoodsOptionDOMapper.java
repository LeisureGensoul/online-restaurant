package com.whu.order.repository.dao;

import com.whu.order.repository.entity.GoodsOptionDO;
import com.whu.order.repository.entity.GoodsOptionDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsOptionDOMapper {
    int countByExample(GoodsOptionDOExample example);

    int deleteByExample(GoodsOptionDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsOptionDO record);

    int insertSelective(GoodsOptionDO record);

    List<GoodsOptionDO> selectByExample(GoodsOptionDOExample example);

    GoodsOptionDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsOptionDO record, @Param("example") GoodsOptionDOExample example);

    int updateByExample(@Param("record") GoodsOptionDO record, @Param("example") GoodsOptionDOExample example);

    int updateByPrimaryKeySelective(GoodsOptionDO record);

    int updateByPrimaryKey(GoodsOptionDO record);
}