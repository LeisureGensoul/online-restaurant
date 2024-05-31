package com.whu.order.controller.admin;

import com.whu.order.admin.order.converter.OrderDataConverter;
import com.whu.order.admin.order.converter.OrderInfoDataConverter;
import com.whu.order.admin.order.bo.AdminOrderFormInfoBO;
import com.whu.order.admin.order.service.AdminOrderService;
import com.whu.order.commons.result.ActionResult;
import com.whu.order.commons.result.PageResult;
import com.whu.order.domain.admin.vo.OrderFormInfoVO;
import com.whu.order.domain.admin.vo.OrderFormVO;
import com.whu.order.repository.entity.OrderFormDO;
import com.whu.order.repository.entity.OrderFormInfoDO;
import com.whu.order.types.PageQuery;
import com.whu.order.types.admin.order.OrderSearchQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping(value = "/onlinerestaurant/admin")
@Api(tags = "管理系统订单接口")
@Validated
@Slf4j
public class AdminOrderController {

    @Autowired
    private OrderDataConverter orderDataConverter;

    @Autowired
    private AdminOrderService adminOrderService;

    @Autowired
    private AdminOrderFormInfoBO adminOrderFormInfoBO;

    @Autowired
    private OrderInfoDataConverter orderInfoDataConverter;

    @ApiOperation("所有订单列表")
    @PostMapping(value = "/order/list/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionResult<Object> getOrderList(@RequestBody @Valid PageQuery query) {
        PageResult<List<OrderFormDO>> pageResult = adminOrderService.getAllOrders(query);

        PageResult<List<OrderFormVO>> result = orderDataConverter.convertOrderPageDO2VO(pageResult);

        log.info("Admin select order list success, pageNo:{}, pageSize:{}", query.getPageNo(), query.getPageSize());
        return ActionResult.getSuccessResult(result);
    }

    @ApiOperation("未完成订单")
    @PostMapping(value = "/order/list/undone", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionResult<PageResult<List<OrderFormVO>>> getUndononlinerestaurant(@RequestBody @Valid PageQuery query) {
        PageResult<List<OrderFormDO>> pageResult = adminOrderService.getUndononlinerestaurants(query);

        PageResult<List<OrderFormVO>> result = orderDataConverter.convertOrderPageDO2VO(pageResult);

        log.info("Admin select order list success, pageNo:{}, pageSize:{}", query.getPageNo(), query.getPageSize());
        return ActionResult.getSuccessResult(result);
    }

    @ApiOperation("订单详情")
    @GetMapping(value = "/order/detail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionResult<Object> getOrderDetailByOrderNum(@NotBlank String orderNum) {
        List<OrderFormInfoDO> orderFormInfoDOS = adminOrderFormInfoBO.getByOrderNum(orderNum);
        List<OrderFormInfoVO> orderFormInfoVOS = orderInfoDataConverter.convertOrderInfoDO2VO(orderFormInfoDOS);

        log.info("Admin select order detail success, orderNum:{}", orderNum);
        return ActionResult.getSuccessResult(orderFormInfoVOS);
    }

    @ApiOperation("配送单个商品")
    @GetMapping(value = "/order/delivery/one", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionResult<Object> deliveryOne(@NotNull Integer orderInfoId) {
        boolean res = adminOrderService.deliveryOne(orderInfoId);
        if (!res) {
            log.info("Admin delivery one failed, orderFormInfoId:{}", orderInfoId);
            return ActionResult.getErrorResult("配送失败");
        }
        log.info("Admin delivery one success, orderFormInfoId:{}", orderInfoId);
        return ActionResult.getSuccessResult("配送成功");
    }

    @ApiOperation("配送所有商品")
    @GetMapping(value = "/order/delivery/all")
    public ActionResult<Object> deliveryAll(@NotBlank(message = "订单号不能为空") String orderNum) {
        boolean res = adminOrderService.deliveryAll(orderNum);
        if (!res) {
            log.info("Admin delivery order failed, orderNum:{}", orderNum);
            return ActionResult.getErrorResult("配送失败");
        }
        log.info("Admin delivery order success, orderNum:{}", orderNum);
        return ActionResult.getSuccessResult("配送成功");
    }

    @ApiOperation("搜索")
    @PostMapping(value = "/order/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionResult<Object> search(@RequestBody @Valid OrderSearchQuery query) {
        PageResult<List<OrderFormDO>> pageResult = adminOrderService.search(query);

        PageResult<List<OrderFormVO>> result = orderDataConverter.convertOrderPageDO2VO(pageResult);

        log.info("Admin search order list success, pageNo:{}, pageSize:{}", query.getPageNo(), query.getPageSize());
        return ActionResult.getSuccessResult(result);
    }
}
