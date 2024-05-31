package com.whu.order.admin.merchant.bo.impl;

import com.whu.order.admin.merchant.bo.MerchantBO;
import com.whu.order.admin.merchant.bo.MerchantRealPictureBO;
import com.whu.order.repository.dao.MerchantRealPictureDOMapper;
import com.whu.order.repository.entity.MerchantDO;
import com.whu.order.repository.entity.MerchantRealPictureDO;
import com.whu.order.repository.entity.MerchantRealPictureDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
public class MerchantRealPictureBOImpl implements MerchantRealPictureBO {

    @Autowired
    private MerchantRealPictureDOMapper merchantRealPictureDOMapper;

    @Autowired
    private MerchantBO merchantBO;

    @Override
    public List<MerchantRealPictureDO> get() {
        MerchantDO merchantDO = merchantBO.get();
        if (merchantDO == null) {
            return null;
        }

        MerchantRealPictureDOExample example = new MerchantRealPictureDOExample();
        example.createCriteria()
                .andMerchantIdEqualTo(merchantDO.getId());

        return merchantRealPictureDOMapper.selectByExample(example);
    }

    @Override
    public int update(List<MerchantRealPictureDO> merchantRealPictureDO) {
        if (CollectionUtils.isEmpty(merchantRealPictureDO)) {
            return 0;
        }
        MerchantDO merchantDO = merchantBO.get();

        MerchantRealPictureDOExample example = new MerchantRealPictureDOExample();

        if (merchantDO != null) {
            Integer merchantId = merchantDO.getId();
            example.createCriteria()
                    .andMerchantIdEqualTo(merchantId);
            merchantRealPictureDOMapper.deleteByExample(example);
            for (MerchantRealPictureDO realPictureDO : merchantRealPictureDO) {
                realPictureDO.setMerchantId(merchantId);
                merchantRealPictureDOMapper.insert(realPictureDO);
            }
        }
        return 1;
    }
}
