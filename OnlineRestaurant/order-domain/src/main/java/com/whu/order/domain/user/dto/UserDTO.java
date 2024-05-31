package com.whu.order.domain.user.dto;

import lombok.Data;


@Data
public class UserDTO {

    private Integer id;

    private String username;

    private String nickname;

    private Integer gender;

    private String city;

    private String province;

    private String country;

    private String avatarUrl;

    private String phone;

}
