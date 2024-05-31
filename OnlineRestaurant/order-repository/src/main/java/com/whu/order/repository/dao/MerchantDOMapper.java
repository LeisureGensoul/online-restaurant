package com.whu.order.repository.dao;

import com.whu.order.repository.entity.MerchantDO;
import com.whu.order.repository.entity.MerchantDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchantDOMapper {
    int countByExample(MerchantDOExample example);

    int deleteByExample(MerchantDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MerchantDO record);

    int insertSelective(MerchantDO record);

    List<MerchantDO> selectByExample(MerchantDOExample example);

    MerchantDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MerchantDO record, @Param("example") MerchantDOExample example);

    int updateByExample(@Param("record") MerchantDO record, @Param("example") MerchantDOExample example);

    int updateByPrimaryKeySelective(MerchantDO record);

    int updateByPrimaryKey(MerchantDO record);
}