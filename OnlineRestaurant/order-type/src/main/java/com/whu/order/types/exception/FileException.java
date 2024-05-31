package com.whu.order.types.exception;


public class FileException extends BaseException{

    public FileException(ErrorType errorType, String message) {
        super(errorType.getCode(), message);
    }

    public FileException(ErrorType errorType, String message, Throwable cause) {
        super(errorType.getCode(), message, cause);
    }
}