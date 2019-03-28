package io.itracybryant.learnspringboot.shiro.service.impl;

import io.itracybryant.learnspringboot.shiro.entity.ShiroUser;
import io.itracybryant.learnspringboot.shiro.mapper.ShiroUserMapper;
import io.itracybryant.learnspringboot.shiro.service.ShiroUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ShiroUserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/26 20:57
 * @Version 1.0
 */
@Service
public class ShiroUserServiceImpl implements ShiroUserService {

    @Autowired
    private ShiroUserMapper shiroUserMapper;

    @Override
    public ShiroUser findByUsername(String username) {
        return shiroUserMapper.findByUsername(username);
    }
}
