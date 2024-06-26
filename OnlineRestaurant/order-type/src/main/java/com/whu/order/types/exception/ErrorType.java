package com.whu.order.types.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ErrorType {

    BIZ_ERROR("5000","业务逻辑异常"),


    PARAM_ERROR("4000","参数异常"),
    PARAM_USER_AUTH("4001","用户无权限访问"),
    PARAM_URL_AUTH("4002","无接口访问权限");

    private String code;
    private String message;

}
