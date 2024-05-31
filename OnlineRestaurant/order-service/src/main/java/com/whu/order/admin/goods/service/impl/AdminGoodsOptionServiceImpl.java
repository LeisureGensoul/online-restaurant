package com.whu.order.admin.goods.service.impl;

import com.whu.order.admin.goods.bo.AdminGoodsOptionBO;
import com.whu.order.admin.goods.service.AdminGoodsOptionService;
import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.admin.vo.AdminGoodsOption;
import com.whu.order.types.PageQuery;
import com.whu.order.types.admin.goods.option.GoodsOptionSearchQuery;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminGoodsOptionServiceImpl implements AdminGoodsOptionService {

    @Autowired
    private AdminGoodsOptionBO adminGoodsOptionBO;

    @Override
    public PageResult<List<AdminGoodsOption>> getAllOptions(PageQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());

        List<AdminGoodsOption> adminGoodsOptions = adminGoodsOptionBO.selectAll();

        PageResult<List<AdminGoodsOption>> pageResult = new PageResult<>(adminGoodsOptions);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        return pageResult;
    }

    @Override
    public PageResult<List<AdminGoodsOption>> search(GoodsOptionSearchQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());

        List<AdminGoodsOption> adminGoodsOptions = adminGoodsOptionBO.search(query.getGoodsName());

        PageResult<List<AdminGoodsOption>> pageResult = new PageResult<>(adminGoodsOptions);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        return pageResult;
    }
}
