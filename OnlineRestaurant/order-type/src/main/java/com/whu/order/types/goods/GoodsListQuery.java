package com.whu.order.types.goods;

import com.whu.order.types.PageQuery;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
@ApiModel(description = "GoodList请求")
public class GoodsListQuery extends PageQuery {
    @NotNull(message = "类型不能为空")
    private Integer goodsType;
}
