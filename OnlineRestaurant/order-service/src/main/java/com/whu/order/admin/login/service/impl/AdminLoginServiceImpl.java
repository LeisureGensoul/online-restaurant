package com.whu.order.admin.login.service.impl;

import com.whu.order.admin.login.bo.AdminBO;
import com.whu.order.admin.login.service.AdminLoginService;
import com.whu.order.domain.user.dto.UserDTO;
import com.whu.order.repository.entity.UserDO;
import com.whu.order.types.user.LoginQuery;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private AdminBO adminBO;

    @Override
    public UserDTO login(LoginQuery query) {
        UserDO userDO = adminBO.selectAdminUserByName(query.getUsername());

        //没有该管理员
        if (userDO == null) {
            return null;
        }
        String encryptedPassword = encryptPassword(query.getPassword(), userDO.getSalt());
        //密码错误
        if (!encryptedPassword.equals(userDO.getPassword())) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);

        return userDTO;
    }

    /**
     * 密码加密
     *
     * @param password 密码
     * @return 加密后密码
     */
    private String encryptPassword(String password, String salt) {
        String saltPassword = DigestUtils.md5Hex(salt + password);

        return saltPassword;
    }
}
