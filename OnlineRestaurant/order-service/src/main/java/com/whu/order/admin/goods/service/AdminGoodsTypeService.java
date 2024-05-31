package com.whu.order.admin.goods.service;

import com.whu.order.commons.result.PageResult;
import com.whu.order.repository.entity.GoodsTypeDO;
import com.whu.order.types.PageQuery;

import java.util.List;


public interface AdminGoodsTypeService {

    PageResult<List<GoodsTypeDO>> getGoodsTypeList(PageQuery query);
}
