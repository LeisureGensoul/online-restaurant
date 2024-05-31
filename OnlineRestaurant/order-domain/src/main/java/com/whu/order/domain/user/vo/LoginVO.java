package com.whu.order.domain.user.vo;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class LoginVO{
    private String token;
    private UserVO userInfo;
}
