package com.whu.order.types.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class UserQuery {

    @NotBlank(message = "手机号不能为空")
    private String phone;

    private String avatarUrl;

    @NotBlank(message = "昵称不能为空")
    private String nickname;
}
