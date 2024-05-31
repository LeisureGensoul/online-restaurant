package com.whu.order.types.user;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Pattern;


@Data
@ApiModel(description = "登录请求")
public class LoginQuery {

    @Pattern(regexp = "\\d{11}$", message = "账号必须为11位数字")
    private String username;

    /**
     * 长度至少为8，至少含有一个字母和一个数字
     */
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "密码格式有误")
    private String password;

    /**
     * 验证码（暂时不写）
     */
    private String code;

}
