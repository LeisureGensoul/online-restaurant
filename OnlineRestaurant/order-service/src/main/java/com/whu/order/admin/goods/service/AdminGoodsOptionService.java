package com.whu.order.admin.goods.service;

import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.admin.vo.AdminGoodsOption;
import com.whu.order.types.PageQuery;
import com.whu.order.types.admin.goods.option.GoodsOptionSearchQuery;

import java.util.List;


public interface AdminGoodsOptionService {

    PageResult<List<AdminGoodsOption>> getAllOptions(PageQuery query);

    PageResult<List<AdminGoodsOption>> search(GoodsOptionSearchQuery query);
}
