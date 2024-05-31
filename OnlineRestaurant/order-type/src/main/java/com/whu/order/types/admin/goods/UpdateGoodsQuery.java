package com.whu.order.types.admin.goods;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class UpdateGoodsQuery extends GoodsQuery {
    @NotNull(message = "id不能为null")
    private Integer id;
}
