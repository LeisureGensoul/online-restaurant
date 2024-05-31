package com.whu.order.domain.user.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;


@Data
public class WxUserDTO {

    private String openId;
    @JSONField(name = "nickName")
    private String nickname;
    private Integer gender;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private Watermark watermark;

    @Data
    class Watermark{
        private String timestamp;
        private String appid;
    }
}
