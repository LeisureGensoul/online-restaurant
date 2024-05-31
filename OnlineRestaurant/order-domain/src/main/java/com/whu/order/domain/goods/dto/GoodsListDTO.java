package com.whu.order.domain.goods.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class GoodsListDTO {

    private String type;

    private Date createTime;

    private Date updateTime;

    private List<GoodsDTO> goods;
}
