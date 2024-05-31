package com.whu.order.types.admin.goods.type;

import com.whu.order.types.PageQuery;
import lombok.Data;


@Data
public class GoodsTypeSearchQuery extends PageQuery {

    private String type;
}
