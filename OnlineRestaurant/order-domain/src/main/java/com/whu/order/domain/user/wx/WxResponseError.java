package com.whu.order.domain.user.wx;

import lombok.Data;


@Data
public class WxResponseError {
    /**
     * 错误码
     */
    private String errcode;

    /**
     * 错误信息
     */
    private String errmsg;
}
