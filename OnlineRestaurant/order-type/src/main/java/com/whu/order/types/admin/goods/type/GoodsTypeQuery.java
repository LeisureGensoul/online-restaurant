package com.whu.order.types.admin.goods.type;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class GoodsTypeQuery {

    @NotBlank(message = "商品类型不能为空")
    private String type;
}
