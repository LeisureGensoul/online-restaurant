package com.whu.order.domain.user.wx;

import lombok.Data;


@Data
public class WxAccessTokenResponse extends WxResponseError{

    private String access_token;
    private String expires_in;
}
