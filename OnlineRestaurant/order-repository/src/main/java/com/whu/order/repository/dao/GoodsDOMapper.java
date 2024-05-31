package com.whu.order.repository.dao;

import com.whu.order.repository.entity.GoodsDO;
import com.whu.order.repository.entity.GoodsDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDOMapper {
    int countByExample(GoodsDOExample example);

    int deleteByExample(GoodsDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsDO record);

    int insertSelective(GoodsDO record);

    List<GoodsDO> selectByExample(GoodsDOExample example);

    GoodsDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsDO record, @Param("example") GoodsDOExample example);

    int updateByExample(@Param("record") GoodsDO record, @Param("example") GoodsDOExample example);

    int updateByPrimaryKeySelective(GoodsDO record);

    int updateByPrimaryKey(GoodsDO record);
}