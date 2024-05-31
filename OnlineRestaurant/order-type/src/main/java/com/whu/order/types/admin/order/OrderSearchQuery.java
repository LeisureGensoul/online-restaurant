package com.whu.order.types.admin.order;

import com.whu.order.types.PageQuery;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class OrderSearchQuery extends PageQuery {
    private String username;

    private String orderNum;

    private String queueNum;

    private Integer deliveryStatus;

    private Integer tradeStatus;

    @NotNull(message = "类型不能为空")
    private Boolean isUndone;
}
