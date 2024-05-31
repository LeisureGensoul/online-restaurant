package com.whu.order.types.user;

import lombok.Data;


@Data
public class WxUserProfile {
    private String rawData;
    private String signature;
    private String encryptedData;
    private String iv;
}
