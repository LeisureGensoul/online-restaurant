package com.whu.order.domain.goods.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class GoodsOptionDTO {

    private Integer id;

    private String optionName;

    private Integer goodsId;

    private Date createTime;

    private Date updateTime;

    private List<GoodsOptionItemDTO> goodsOptionItems;

}
