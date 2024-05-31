package com.whu.order.domain.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RecordVO {

    private String number;

    /**
     * 比昨天
     */
    private String rate;
}
