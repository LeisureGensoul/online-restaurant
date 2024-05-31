package com.whu.order.admin.record.service;

import com.whu.order.domain.admin.vo.RecordVO;


public interface RecordService {

    /**
     * 日访问量
     * @return 日访问量
     */
    RecordVO getDailyVisit();

    /**
     * 日销量
     * @return 日销量
     */
    RecordVO getDailySales();

    /**
     * 日收入
     * @return 日收入
     */
    RecordVO getDailyIncome();

    /**
     * 日评论量
     * @return 日评论量
     */
    RecordVO getDailyCommentNum();

    /**
     * 持久化每日数据
     * @return 影响行数
     */
    int recordTask();
}
