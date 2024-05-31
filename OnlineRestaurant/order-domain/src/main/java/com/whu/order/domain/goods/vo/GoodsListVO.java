package com.whu.order.domain.goods.vo;

import lombok.Data;

import java.util.List;


@Data
public class GoodsListVO {

    private String type;

    private List<GoodsVO> goods;
}
