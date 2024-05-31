package com.whu.order.types.admin.goods.option;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
public class GoodsOptionQuery {

    @NotNull(message = "商品id不能为空")
    private Integer goodsId;

    @NotBlank(message = "规格名称不能为空")
    private String OptionName;

    private List<OptionItem> optionItems;
}
