package com.whu.order.controller.admin;

import com.whu.order.admin.record.service.RecordService;
import com.whu.order.commons.result.ActionResult;
import com.whu.order.domain.admin.vo.RecordVO;
import com.whu.order.redis.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/onlinerestaurant/admin")
@Api(tags = "管理系统主页接口")
@Slf4j
public class AdminIndexController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RecordService recordService;

    @GetMapping(value = "/index/visit", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("获取日访问量")
    public ActionResult<Object> getDailyVisit() {
        RecordVO dailyVisit = recordService.getDailyVisit();
        log.info("Admin get daily visit number success");
        return ActionResult.getSuccessResult("成功", dailyVisit);
    }

    @GetMapping(value = "/index/sale", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("获取日销量")
    public ActionResult<Object> getDailySale() {
        RecordVO dailySales = recordService.getDailySales();
        log.info("Admin get daily sales success");
        return ActionResult.getSuccessResult("成功", dailySales);
    }

    @GetMapping(value = "/index/income", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("获取日收入")
    public ActionResult<Object> getDailyIncome() {
        RecordVO dailyIncome = recordService.getDailyIncome();
        log.info("Admin get daily sales success");
        return ActionResult.getSuccessResult("成功", dailyIncome);
    }

    @GetMapping(value = "/index/comment", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("获取日评论")
    public ActionResult<Object> getDailyComment() {
        RecordVO commentNum = recordService.getDailyCommentNum();
        log.info("Admin get daily comment success");
        return ActionResult.getSuccessResult("成功", commentNum);
    }
}
