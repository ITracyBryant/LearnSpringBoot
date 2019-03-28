package io.itracybryant.learnspringboot.mybatis.mapper;

import io.itracybryant.learnspringboot.mybatis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperAnoTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapperAno userMapperAno;

    @Test
    public void findAll() {
        List<User> list = userMapperAno.findAll();
        list.forEach(user -> {
            logger.info("user = {}", user);
        });
    }

    @Test
    public void findById() {
        logger.info("user = {}", userMapperAno.findById(5L));
    }

    @Test
    public void save() {
        User user = new User();
        user.setUsername("test01");
        user.setPassword("1234");
        user.setCreateTime(new Date());
        userMapperAno.save(user);
        findAll();
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(5L);
        user.setUsername("改");
        userMapperAno.update(user);
        findAll();
    }

    @Test
    public void delete() {
        userMapperAno.delete(6L);
        findAll();
    }
}