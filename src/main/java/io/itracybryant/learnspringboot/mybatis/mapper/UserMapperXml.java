package io.itracybryant.learnspringboot.mybatis.mapper;

import io.itracybryant.learnspringboot.mybatis.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName UserMapperXml
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/9 18:52
 * @Version 1.0
 */
@Component
public interface UserMapperXml {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void update(User user);

    void delete(Long id);
}
