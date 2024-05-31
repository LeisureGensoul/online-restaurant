package com.whu.order.admin.goods.service.impl;

import com.whu.order.admin.goods.bo.AdminGoodsTypeBO;
import com.whu.order.admin.goods.service.AdminGoodsTypeService;
import com.whu.order.commons.result.PageResult;
import com.whu.order.repository.entity.GoodsTypeDO;
import com.whu.order.types.PageQuery;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminGoodsTypeServiceImpl implements AdminGoodsTypeService {

    @Autowired
    private AdminGoodsTypeBO adminGoodsTypeBO;

    @Override
    public PageResult<List<GoodsTypeDO>> getGoodsTypeList(PageQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());

        List<GoodsTypeDO> goodsTypeDOList = adminGoodsTypeBO.getAll();

        PageResult<List<GoodsTypeDO>> pageResult = new PageResult<>(goodsTypeDOList);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        return pageResult;
    }
}
