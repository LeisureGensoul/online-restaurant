package com.whu.order.admin.login.bo;

import com.whu.order.repository.entity.UserDO;


public interface AdminBO {

    /**
     * 查询管理员用户
     * @param username 用户名
     * @return 管理员用户
     */
    UserDO selectAdminUserByName(String username);
}
