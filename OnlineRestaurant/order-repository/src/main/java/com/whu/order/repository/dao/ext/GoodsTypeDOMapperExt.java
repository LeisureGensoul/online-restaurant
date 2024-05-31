package com.whu.order.repository.dao.ext;

import com.whu.order.repository.entity.GoodsTypeDO;

import java.util.List;


public interface GoodsTypeDOMapperExt {
    /**
     * 查询所有Goods Type
     * @return GoodsTypeDO
     */
    List<GoodsTypeDO> selectAllGoodsType();

    /**
     * 根据value进行模糊查询type
     * @param value 搜索值
     * @return 商品类型
     */
    List<GoodsTypeDO> selectTypeLikeValue(String value);

}
