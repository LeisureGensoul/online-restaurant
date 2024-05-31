package com.whu.order.domain.user.wx;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class WxLoginResponse extends WxResponseError {

    @JSONField(name = "openid")
    private String openid;

    @JSONField(name = "session_key")
    private String session_key;

    @JSONField(name = "unionid")
    private String unionid;

}
