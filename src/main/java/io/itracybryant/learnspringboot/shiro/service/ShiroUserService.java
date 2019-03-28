package io.itracybryant.learnspringboot.shiro.service;

import io.itracybryant.learnspringboot.shiro.entity.ShiroUser;

/**
 * @InterfaceName ShiroUserService
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/26 20:56
 * @Version 1.0
 */
public interface ShiroUserService {
    ShiroUser findByUsername(String username);
}
