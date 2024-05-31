package com.whu.order.task;

import com.whu.order.admin.bill.service.BillService;
import com.whu.order.admin.comment.service.AdminCommentService;
import com.whu.order.admin.goods.service.AdminGoodsService;
import com.whu.order.admin.record.service.RecordService;
import com.whu.order.mini.coupon.bo.UserCouponBO;
import com.whu.order.mini.order.bo.OrderFormBO;
import com.whu.order.mini.order.service.OrderService;
import com.whu.order.repository.entity.OrderFormDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class TaskServiceImpl implements TaskService{

    @Autowired
    private UserCouponBO userCouponBO;

    @Autowired
    private OrderFormBO orderFormBO;

    @Autowired
    private OrderService orderService;

    @Autowired
    private BillService billService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private AdminCommentService adminCommentService;

    @Autowired
    private AdminGoodsService adminGoodsService;

    /**
     * 用户优惠券失效任务，每3小时执行一次
     */
    @Scheduled(cron = "0 0 0/3 * * ?")
    @Override
    public void userCouponExpireTask() {
        int i = userCouponBO.updateExpiredCoupon();
        log.info("execute update user expire coupon task success, update rows:{}", i);
    }

    /**
     * 未支付订单失效任务，每小时执行一次
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    @Override
    public void orderUnpaidExpireTask() {
        log.info("execute update expired order task success");
        List<OrderFormDO> expiredOrders = orderFormBO.selectExpiredOrderForm();
        for (OrderFormDO order: expiredOrders) {
            boolean result = orderService.cancelOrder(order.getOrderNum(), order.getUserId());
            if(result){
                log.info("update expired order task success, orderNum:{}", order.getOrderNum());
            }
        }
    }

    /**
     * 系统账单任务，每天23点执行一次
     */
    @Scheduled(cron = "0 0 23 * * ?")
    @Override
    public void billTask() {
        billService.billTask();
        log.info("execute bill task success");
    }

    /**
     * 记录每日系统数据任务，每天23点执行一次
     */
    @Scheduled(cron = "0 0 23 * * ?")
    @Override
    public void recordDailyNumber() {
        recordService.recordTask();
        log.info("execute record daily statistics success");
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    @Override
    public void autoReply(){
        int i = adminCommentService.autoReply();
        log.info("execute auto reply task success, rows:" + i);
    }

    @Scheduled(cron = "0 0 23 * * ?")
    @Override
    public void calculateCommentScore() {
        int i = adminCommentService.calculateCommentScore();
        log.info("execute calculate comment score success, rows:" + i);
    }

    @Scheduled(cron = "0 0 23 * * ?")
    @Override
    public void calculateGoodsScore(){
        int i = adminGoodsService.calculateGoodsScore();
        log.info("execute calculate goods score success");
    }
}
