package com.whu.order.domain.user.wx;

import com.whu.order.domain.user.dto.UserDTO;
import lombok.Data;


@Data
public class LoginUser extends UserDTO {

    private String openid;
    private String session_key;
    private String unionid;

}
