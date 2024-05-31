package com.whu.order.admin.merchant.bo;

import com.whu.order.repository.entity.MerchantDO;


public interface MerchantBO {

    /**
     * 得到商户信息
     *
     * @return 商户信息
     */
    MerchantDO get();

    /**
     * 修改商户信息
     *
     * @param merchantDO 商户
     * @return 行数
     */
    int update(MerchantDO merchantDO);
}
