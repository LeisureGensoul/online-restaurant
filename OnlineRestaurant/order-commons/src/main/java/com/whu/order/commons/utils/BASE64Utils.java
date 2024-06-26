package com.whu.order.commons.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class BASE64Utils {

    public static String encodeBase64(String msg) {
        byte[] encode = Base64.getEncoder().encode(msg.getBytes(StandardCharsets.UTF_8));

        return new String(encode,StandardCharsets.UTF_8);
    }

    public static String parseBase64(String msg) {
        byte[] decode = Base64.getDecoder().decode(msg);

        return new String(decode, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        String base64 = encodeBase64("qDGU*8ZLDP");
        System.out.println("加密后："+base64);
        System.out.println("解密后："+parseBase64(base64));

    }
}
