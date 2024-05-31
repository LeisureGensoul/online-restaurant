package com.whu.order.types.exception;

import lombok.Getter;


@Getter
public class BaseException extends RuntimeException{

    private String code;

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }


}
