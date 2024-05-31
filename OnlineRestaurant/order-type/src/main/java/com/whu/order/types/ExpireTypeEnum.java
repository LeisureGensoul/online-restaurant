package com.whu.order.types;


public enum ExpireTypeEnum {

    /**
     * 是
     */
    YES("y"),

    /**
     * 否
     */
    NO("n");

    private String type;

    ExpireTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
