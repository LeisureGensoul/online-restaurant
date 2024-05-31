package com.whu.order.mini.user.bo;

import com.whu.order.repository.entity.UserDO;
import com.whu.order.types.user.UserQuery;


public interface UserBO {

    UserDO getUserById(Integer userId);

    UserDO getUserByUsername(String username);

    int updateUser(UserQuery query, Integer userId);

}
