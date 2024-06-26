package com.whu.order.admin.order.service.impl;

import com.whu.order.admin.order.bo.AdminOrderBO;
import com.whu.order.admin.order.bo.AdminOrderFormInfoBO;
import com.whu.order.admin.order.service.AdminOrderService;
import com.whu.order.commons.result.PageResult;
import com.whu.order.repository.entity.OrderFormDO;
import com.whu.order.repository.entity.OrderFormInfoDO;
import com.whu.order.types.PageQuery;
import com.whu.order.types.admin.order.OrderSearchQuery;
import com.whu.order.types.exception.BusinessException;
import com.whu.order.types.exception.ErrorType;
import com.whu.order.types.payment.DeliveryStatus;
import com.whu.order.types.payment.TradeStatus;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;


@Service
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    private AdminOrderBO adminOrderBO;

    @Autowired
    private AdminOrderFormInfoBO adminOrderFormInfoBO;

    @Override
    public PageResult<List<OrderFormDO>> getAllOrders(PageQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());

        List<OrderFormDO> orders = adminOrderBO.getAllOrders(query);

        PageResult<List<OrderFormDO>> pageResult = new PageResult<>(orders);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        return pageResult;
    }

    @Override
    public PageResult<List<OrderFormDO>> getUndononlinerestaurants(PageQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());
        List<OrderFormDO> orders = adminOrderBO.getUndononlinerestaurants(query);

        PageResult<List<OrderFormDO>> pageResult = new PageResult<>(orders);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());
        return pageResult;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deliveryOne(Integer orderInfoId) {
        OrderFormInfoDO orderFormInfo = adminOrderFormInfoBO.getById(orderInfoId);
        if (orderFormInfo.getDeliveryStatus().equals(DeliveryStatus.DELIVERED.getCode())) {
            return false;
        }
        String orderNum = orderFormInfo.getOrderNum();
        OrderFormDO order = adminOrderBO.getByOrderNum(orderNum).get(0);
        //订单不是待配送状态
        if (!order.getTradeStatus().equals(TradeStatus.NOT_DELIVERY.getCode())) {
            return false;
        }

        OrderFormInfoDO orderFormInfoDO = new OrderFormInfoDO();
        orderFormInfoDO.setId(orderInfoId);
        orderFormInfoDO.setDeliveryStatus(DeliveryStatus.DELIVERED.getCode());
        int i = adminOrderFormInfoBO.updateByIdSelective(orderFormInfoDO);

        //是否全部已配送
        List<OrderFormInfoDO> orderFormInfoDOS = adminOrderFormInfoBO.getByOrderNum(orderNum);
        boolean allDelivery = orderFormInfoDOS.stream()
                .allMatch(o -> o.getDeliveryStatus().equals(DeliveryStatus.DELIVERED.getCode()));

        if (allDelivery) {
            //更新订单表
            this.setOrderFormDelivery(orderNum);
        }

        return i > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deliveryAll(String orderNum) {
        List<OrderFormDO> orders = adminOrderBO.getByOrderNum(orderNum);
        if (CollectionUtils.isEmpty(orders)) {
            throw new BusinessException(ErrorType.PARAM_ERROR, "没有该订单");
        }

        OrderFormDO order = orders.get(0);
        Integer tradeStatus = order.getTradeStatus();
        //订单不是待配送状态
        if (!tradeStatus.equals(TradeStatus.NOT_DELIVERY.getCode())) {
            return false;
        }

        //修改订单表
        boolean formDelivery = this.setOrderFormDelivery(orderNum);

        //订单详情表
        OrderFormInfoDO orderFormInfoDO = new OrderFormInfoDO();
        orderFormInfoDO.setDeliveryStatus(DeliveryStatus.DELIVERED.getCode());
        int i = adminOrderFormInfoBO.updateByOrderNumSelective(orderNum, orderFormInfoDO);

        return i > 0 && formDelivery;
    }

    @Override
    public PageResult<List<OrderFormDO>> search(OrderSearchQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNo(), query.getPageSize());

        List<OrderFormDO> orders = adminOrderBO.search(query);

        PageResult<List<OrderFormDO>> pageResult = new PageResult<>(orders);
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());

        return pageResult;
    }

    private boolean setOrderFormDelivery(String orderNum) {
        //修改订单表
        OrderFormDO orderFormDO = new OrderFormDO();
        orderFormDO.setDeliveryStatus(DeliveryStatus.DELIVERED.getCode());
        orderFormDO.setTradeStatus(TradeStatus.FINISHED.getCode());
        orderFormDO.setCloseTime(new Date());

        int i = adminOrderBO.updatonlinerestaurantFormByOrderNum(orderNum, orderFormDO);

        return i > 0;
    }
}
