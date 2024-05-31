package com.whu.order.admin.user.bo;

import com.whu.order.repository.entity.UserDO;


public interface AdminUserBO {

    UserDO getById(Integer userId);

    UserDO getByUsername(String username);
}
