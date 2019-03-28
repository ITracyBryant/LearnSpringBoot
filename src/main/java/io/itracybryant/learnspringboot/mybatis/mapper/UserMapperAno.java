package io.itracybryant.learnspringboot.mybatis.mapper;

import io.itracybryant.learnspringboot.mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName UserMapperAno
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/9 16:33
 * @Version 1.0
 */
@Component
public interface UserMapperAno {

    @Select("select * from user")
    @Results({
            @Result(property = "createTime", column = "create_time")
    })
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "createTime", column = "create_time")
    })
    User findById(Long id);

    @Insert("insert into user(username, password,create_time) values(#{username},#{password},#{createTime})")
    void save(User user);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    void update(User user);

    @Delete("delete from user where id=#{id}")
    void delete(Long id);
}
