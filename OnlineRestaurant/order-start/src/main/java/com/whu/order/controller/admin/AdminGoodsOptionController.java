package com.whu.order.controller.admin;

import com.whu.order.admin.goods.bo.AdminGoodsOptionBO;
import com.whu.order.admin.goods.service.AdminGoodsOptionService;
import com.whu.order.commons.result.ActionResult;
import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.admin.vo.AdminGoodsOption;
import com.whu.order.types.PageQuery;
import com.whu.order.types.admin.goods.option.GoodsOptionQuery;
import com.whu.order.types.admin.goods.option.GoodsOptionSearchQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/onlinerestaurant/admin")
@Api(tags = "管理系统商品规格接口")
@Slf4j
public class AdminGoodsOptionController {


    @Autowired
    private AdminGoodsOptionService adminGoodsOptionService;

    @Autowired
    private AdminGoodsOptionBO adminGoodsOptionBO;

    @PostMapping(value = "/goods/option/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("得到规格列表")
    public ActionResult<Object> getOptionsList(@RequestBody @Valid PageQuery query) {
        PageResult<List<AdminGoodsOption>> options = adminGoodsOptionService.getAllOptions(query);

        log.info("Admin select goodsOption success");
        return ActionResult.getSuccessResult(options);
    }

    @ApiOperation("搜索")
    @PostMapping(value = "/goods/option/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionResult<PageResult<List<AdminGoodsOption>>> search(@RequestBody @Valid GoodsOptionSearchQuery query) {
        PageResult<List<AdminGoodsOption>> options = adminGoodsOptionService.search(query);

        log.info("Admin select goodsOption success");
        return ActionResult.getSuccessResult(options);
    }

    @ApiOperation("添加选规格")
    @PostMapping(value = "/goods/option/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionResult<Object> addGoodsOption(@RequestBody @Valid GoodsOptionQuery query) {

        int i = adminGoodsOptionBO.addGoodsOption(query);
        log.info("Admin add goods type success");
        return ActionResult.getSuccessResult("成功");
    }
}
