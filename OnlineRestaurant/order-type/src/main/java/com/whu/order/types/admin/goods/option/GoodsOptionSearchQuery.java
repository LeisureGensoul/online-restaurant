package com.whu.order.types.admin.goods.option;

import com.whu.order.types.PageQuery;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class GoodsOptionSearchQuery extends PageQuery {
    @NotBlank(message = "名称不能为空")
    private String goodsName;
}
