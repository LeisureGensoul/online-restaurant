package com.whu.order.types.exception;


public class ParamException extends BaseException{

    public ParamException(ErrorType errorType,String message){
        super(errorType.getCode(), message);
    }
}
