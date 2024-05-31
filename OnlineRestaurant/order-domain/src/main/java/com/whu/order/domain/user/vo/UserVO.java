package com.whu.order.domain.user.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class UserVO {

    @JsonProperty("nickName")
    private String nickname;

    private Integer gender;

    private String city;

    private String province;

    private String country;

    private String avatarUrl;

    private String phone;
}
