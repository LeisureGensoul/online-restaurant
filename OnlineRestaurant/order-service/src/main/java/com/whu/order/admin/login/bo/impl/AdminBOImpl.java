package com.whu.order.admin.login.bo.impl;

import com.whu.order.admin.login.bo.AdminBO;
import com.whu.order.repository.dao.UserDOMapper;
import com.whu.order.repository.entity.UserDO;
import com.whu.order.repository.entity.UserDOExample;
import com.whu.order.types.user.UserTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
public class AdminBOImpl implements AdminBO {

    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public UserDO selectAdminUserByName(String username) {
        UserDOExample example = new UserDOExample();
        example.createCriteria()
                .andUsernameEqualTo(username)
                .andTypeEqualTo(UserTypeEnum.ADMIN_USER.getCode())
                .andIsDeleteEqualTo("n");

        List<UserDO> userDOList = userDOMapper.selectByExample(example);

        return CollectionUtils.isEmpty(userDOList) ? null : userDOList.get(0);
    }

}
