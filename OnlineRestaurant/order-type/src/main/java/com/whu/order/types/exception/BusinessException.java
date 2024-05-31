package com.whu.order.types.exception;


public class BusinessException extends BaseException{


    public BusinessException(ErrorType errorType, String message, Throwable cause) {
        super(errorType.getCode(), message, cause);
    }

    public BusinessException(ErrorType errorType,String message){
        super(errorType.getCode(),message);
    }
}
