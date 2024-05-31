package com.whu.order.types.admin.goods.type;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class GoodsTypeUpdateQuery extends GoodsTypeQuery {

    @NotNull(message = "商品类型id不能为null")
    private Integer id;
}
