package com.whu.order.admin.goods.bo;

import com.whu.order.domain.admin.vo.AdminGoodsOption;
import com.whu.order.types.admin.goods.option.GoodsOptionQuery;

import java.util.List;


public interface AdminGoodsOptionBO {

    List<AdminGoodsOption> selectAll();

    List<AdminGoodsOption> search(String goodsName);

    int addGoodsOption(GoodsOptionQuery query);
}
