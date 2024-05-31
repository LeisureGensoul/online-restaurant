package com.whu.order.repository.dao.ext;

import com.whu.order.repository.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDOMapperExt {

    UserDO selectByUsername(String username);

    UserDO selectByUsernameAndPassword(String username,String password);

    UserDO selectByOpenId(String openId);
}
