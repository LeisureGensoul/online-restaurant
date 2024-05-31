package com.whu.order.types;


public enum SwitchTypeEnum {

    ON("on"),
    OFF("off");

    private final String content;

    SwitchTypeEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
