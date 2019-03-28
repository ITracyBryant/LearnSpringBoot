package io.itracybryant.learnspringboot.shiro.mapper;

import io.itracybryant.learnspringboot.shiro.entity.ShiroUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @ClassName ShiroUserMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/26 20:54
 * @Version 1.0
 */
@Component
@Mapper
public interface ShiroUserMapper {
    @Select("select * from shirouser where username = #{username}")
    ShiroUser findByUsername(String username);
}
