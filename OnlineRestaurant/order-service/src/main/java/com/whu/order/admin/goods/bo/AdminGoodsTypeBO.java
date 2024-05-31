package com.whu.order.admin.goods.bo;

import com.whu.order.repository.entity.GoodsTypeDO;
import com.whu.order.types.admin.goods.type.GoodsTypeQuery;
import com.whu.order.types.admin.goods.type.GoodsTypeUpdateQuery;

import java.util.List;


public interface AdminGoodsTypeBO {

    List<GoodsTypeDO> getAll();

    int updateById(GoodsTypeUpdateQuery query);

    int add(GoodsTypeQuery query);

    int delete(Integer id);

    List<GoodsTypeDO> searchByType(String type);
}
