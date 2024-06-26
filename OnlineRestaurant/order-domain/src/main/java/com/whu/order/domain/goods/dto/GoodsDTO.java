package com.whu.order.domain.goods.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class GoodsDTO {

    private Integer id;

    private String goodsName;

    private String description;

    private String ingredients;

    private String weight;

    private String taste;

    private String isMeat;

    private Double price;

    private Integer stock;

    private Integer sales;

    private Double score;

    private Double cost;

    private Integer goodsType;

    private Date createTime;

    private Date updateTime;

    private List<GoodsPictureDTO> pictures;

    private List<GoodsOptionDTO> goodsOptions;

}
