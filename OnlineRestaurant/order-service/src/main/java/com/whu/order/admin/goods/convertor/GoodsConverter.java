package com.whu.order.admin.goods.convertor;

import com.whu.order.admin.goods.bo.AdminGoodsTypeBO;
import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.admin.vo.AdminGoodsVO;
import com.whu.order.repository.entity.GoodsDO;
import com.whu.order.repository.entity.GoodsTypeDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class GoodsConverter {

    @Autowired
    private AdminGoodsTypeBO adminGoodsTypeBO;

    public PageResult<List<AdminGoodsVO>> convert2GoodsPageVo(PageResult<List<GoodsDO>> pageResult) {
        PageResult<List<AdminGoodsVO>> result = new PageResult<>();
        List<AdminGoodsVO> goodsVOS = new ArrayList<>();

        List<GoodsTypeDO> types = adminGoodsTypeBO.getAll();
        List<GoodsDO> goods = pageResult.getData();
        goods.forEach(goodsDO -> {
            AdminGoodsVO adminGoodsVO = new AdminGoodsVO();
            BeanUtils.copyProperties(goodsDO, adminGoodsVO);
            List<GoodsTypeDO> collect = types.stream()
                    .filter(goodsTypeDO -> goodsTypeDO.getId().equals(goodsDO.getGoodsType()))
                    .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(collect)) {
                adminGoodsVO.setGoodsType(collect.get(0).getType());
            }
            goodsVOS.add(adminGoodsVO);
        });

        BeanUtils.copyProperties(pageResult, result);
        result.setData(goodsVOS);
        return result;
    }
}
