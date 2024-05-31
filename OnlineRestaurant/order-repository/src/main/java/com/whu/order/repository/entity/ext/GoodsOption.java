package com.whu.order.repository.entity.ext;

import com.whu.order.repository.entity.GoodsOptionDO;
import com.whu.order.repository.entity.GoodsOptionItemDO;

import java.util.List;


public class GoodsOption extends GoodsOptionDO {

    private List<GoodsOptionItemDO> goodsOptionItems;

    public List<GoodsOptionItemDO> getGoodsOptionItems() {
        return goodsOptionItems;
    }

    public void setGoodsOptionItems(List<GoodsOptionItemDO> goodsOptionItems) {
        this.goodsOptionItems = goodsOptionItems;
    }
}
