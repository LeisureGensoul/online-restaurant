package com.whu.order.admin.user.bo.impl;

import com.whu.order.admin.user.bo.AdminUserBO;
import com.whu.order.repository.dao.UserDOMapper;
import com.whu.order.repository.entity.UserDO;
import com.whu.order.repository.entity.UserDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
public class AdminUserBOImpl implements AdminUserBO {

    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public UserDO getById(Integer userId) {
        UserDOExample example = new UserDOExample();
        example.createCriteria()
                .andIdEqualTo(userId)
                .andIsDeleteEqualTo("n");

        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userDOS)) {
            return null;
        }
        return userDOS.get(0);
    }

    @Override
    public UserDO getByUsername(String username) {
        UserDOExample example = new UserDOExample();
        example.createCriteria()
                .andUsernameEqualTo(username)
                .andIsDeleteEqualTo("n");

        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userDOS)) {
            return null;
        }
        return userDOS.get(0);
    }

}
