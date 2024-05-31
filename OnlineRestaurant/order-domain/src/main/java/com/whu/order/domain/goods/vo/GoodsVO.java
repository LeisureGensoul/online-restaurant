package com.whu.order.domain.goods.vo;

import lombok.Data;

import java.util.List;


@Data
public class GoodsVO {
    private Integer id;

    private String goodsName;

    private String description;

    private String ingredients;

    private String weight;

    private String taste;

    private String isMeat;

    private Double price;

    private Integer sales;

    private Double score;

    private List<GoodsPictureVO> pictures;

    private List<GoodsOptionVO> goodsOptions;
}
