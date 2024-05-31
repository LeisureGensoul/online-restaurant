package com.whu.order.mini.user.bo.impl;

import com.whu.order.mini.user.bo.UserBO;
import com.whu.order.repository.dao.UserDOMapper;
import com.whu.order.repository.entity.UserDO;
import com.whu.order.repository.entity.UserDOExample;
import com.whu.order.types.user.UserQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
public class UserBOImpl implements UserBO {

    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public UserDO getUserById(Integer userId) {
        return userDOMapper.selectByPrimaryKey(userId);
    }

    @Override
    public UserDO getUserByUsername(String username) {
        UserDOExample example = new UserDOExample();
        example.createCriteria()
                .andUsernameEqualTo(username);
        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userDOS)) {
            return null;
        }
        return userDOS.get(0);
    }

    @Override
    public int updateUser(UserQuery query, Integer userId) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(query, userDO);
        userDO.setId(userId);

        return userDOMapper.updateByPrimaryKeySelective(userDO);
    }
}
