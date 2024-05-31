package com.whu.order.repository.entity.ext;

import com.whu.order.repository.entity.GoodsDO;
import com.whu.order.repository.entity.GoodsPictureDO;

import java.util.List;


public class Goods extends GoodsDO {

    private List<GoodsPictureDO> pictures;

    private List<GoodsOption> goodsOptions;

    public List<GoodsPictureDO> getPictures() {
        return pictures;
    }

    public void setPictures(List<GoodsPictureDO> pictures) {
        this.pictures = pictures;
    }

    public List<GoodsOption> getGoodsOptions() {
        return goodsOptions;
    }

    public void setGoodsOptions(List<GoodsOption> goodsOptions) {
        this.goodsOptions = goodsOptions;
    }
}
