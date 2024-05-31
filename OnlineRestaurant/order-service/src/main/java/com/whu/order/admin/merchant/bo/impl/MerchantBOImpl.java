package com.whu.order.admin.merchant.bo.impl;

import com.whu.order.admin.merchant.bo.MerchantBO;
import com.whu.order.repository.dao.MerchantDOMapper;
import com.whu.order.repository.entity.MerchantDO;
import com.whu.order.repository.entity.MerchantDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
public class MerchantBOImpl implements MerchantBO {

    @Autowired
    private MerchantDOMapper merchantDOMapper;

    @Override
    public MerchantDO get() {
        MerchantDOExample example = new MerchantDOExample();
        List<MerchantDO> merchantDOS = merchantDOMapper.selectByExample(example);

        if (CollectionUtils.isEmpty(merchantDOS)) {
            return null;
        }
        return merchantDOS.get(0);
    }

    @Override
    public int update(MerchantDO merchantDO) {
        MerchantDO old = this.get();
        if (old == null) {
            return merchantDOMapper.insertSelective(merchantDO);
        }
        merchantDO.setId(old.getId());
        return merchantDOMapper.updateByPrimaryKeySelective(merchantDO);
    }
}
