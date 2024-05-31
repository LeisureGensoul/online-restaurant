package com.whu.order.admin.merchant.bo;

import com.whu.order.repository.entity.MerchantRealPictureDO;

import java.util.List;


public interface MerchantRealPictureBO {

    /**
     * 得到商户实景图片
     * @return 图片
     */
    List<MerchantRealPictureDO> get();

    /**
     * 更新商家实体图片
     * @param merchantRealPictureDO 图片
     * @return i
     */
    int update(List<MerchantRealPictureDO> merchantRealPictureDO);
}
