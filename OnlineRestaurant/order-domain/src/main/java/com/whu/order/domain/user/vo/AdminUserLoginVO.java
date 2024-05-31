package com.whu.order.domain.user.vo;

import lombok.Data;


@Data
public class AdminUserLoginVO {

    private String token;

    private String nickname;

    private String avatarUrl;
}
