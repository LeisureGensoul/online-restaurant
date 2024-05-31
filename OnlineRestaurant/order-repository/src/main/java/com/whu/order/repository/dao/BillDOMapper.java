package com.whu.order.repository.dao;

import com.whu.order.repository.entity.BillDO;
import com.whu.order.repository.entity.BillDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillDOMapper {
    int countByExample(BillDOExample example);

    int deleteByExample(BillDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BillDO record);

    int insertSelective(BillDO record);

    List<BillDO> selectByExample(BillDOExample example);

    BillDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BillDO record, @Param("example") BillDOExample example);

    int updateByExample(@Param("record") BillDO record, @Param("example") BillDOExample example);

    int updateByPrimaryKeySelective(BillDO record);

    int updateByPrimaryKey(BillDO record);
}