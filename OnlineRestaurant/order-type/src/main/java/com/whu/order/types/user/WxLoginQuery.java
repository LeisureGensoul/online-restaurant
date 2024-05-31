package com.whu.order.types.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class WxLoginQuery {
    @NotBlank
    private String code;
}
