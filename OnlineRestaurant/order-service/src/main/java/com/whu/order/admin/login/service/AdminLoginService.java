package com.whu.order.admin.login.service;

import com.whu.order.domain.user.dto.UserDTO;
import com.whu.order.types.user.LoginQuery;


public interface AdminLoginService {

    /**
     * 管理系统登录
     * @param query
     * @return 登录结果
     */
    UserDTO login(LoginQuery query);
}
