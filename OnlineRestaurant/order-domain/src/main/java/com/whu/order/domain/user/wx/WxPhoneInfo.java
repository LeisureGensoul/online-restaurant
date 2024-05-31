package com.whu.order.domain.user.wx;

import lombok.Data;


@Data
public class WxPhoneInfo extends WxResponseError{
    private String phoneNumber;
    private String purePhoneNumber;
    private String countryCode;
    private Watermark watermark;
}

@Data
class Watermark{
    private String appid;
    private String timestamp;
}

