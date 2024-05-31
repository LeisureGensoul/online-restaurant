package com.whu.order.domain.goods.vo;

import lombok.Data;

import java.util.List;


@Data
public class GoodsOptionVO {

    private Integer id;

    private String optionName;

    private List<GoodsOptionItemVO> goodsOptionItems;

}
