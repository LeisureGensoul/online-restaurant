package com.whu.order.admin.merchant.convertor;

import com.whu.order.repository.entity.MerchantRealPictureDO;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class MerchantConvertor {

    public List<String> convert2MerchantRealPictureVO(List<MerchantRealPictureDO> merchantRealPictureDOS) {
        return merchantRealPictureDOS.stream()
                .map(MerchantRealPictureDO::getPicUrl).collect(Collectors.toList());
    }

    public List<MerchantRealPictureDO> convert2PictureDO(List<String> picUrls) {
        if (CollectionUtils.isEmpty(picUrls)) {
            return null;
        }
        List<MerchantRealPictureDO> res = new ArrayList<>();
        Date createTime = new Date();
        for (String url : picUrls) {
            MerchantRealPictureDO pictureDO = new MerchantRealPictureDO();
            pictureDO.setPicUrl(url);
            pictureDO.setCreateTime(createTime);
            pictureDO.setUpdateTime(createTime);
            res.add(pictureDO);
        }

        return res;
    }

}
