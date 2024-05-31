package com.whu.order.domain.user.vo;

import lombok.Data;

import java.util.List;


@Data
public class MerchantVO {

    private String storeName;

    private String headerUrl;

    private String description;

    private String businessTime;

    private String province;

    private String city;

    private String district;

    private String address;

    private String phone;

    private String announcement;

    private Double score;

    private List<String> realPictureUrl;
}
