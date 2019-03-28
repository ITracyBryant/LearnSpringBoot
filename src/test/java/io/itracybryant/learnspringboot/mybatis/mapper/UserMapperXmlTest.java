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
public class UserMapperXmlTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapperXml userMapperXml;

    @Test
    public void findAll() {
        List<User> list = userMapperXml.findAll();
        list.forEach(user -> {
            logger.info("user = {}",user);
        });
    }

    @Test
    public void findById() {
        logger.info("user = {}", userMapperXml.findById(5L));
    }

    @Test
    public void save() {
        User user = new User();
        user.setUsername("test011");
        user.setPassword("1234");
        user.setCreateTime(new Date());
        userMapperXml.save(user);
        findAll();
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(7L);
        user.setUsername("+++1");
        userMapperXml.update(user);
        findAll();
    }

    @Test
    public void delete() {
        userMapperXml.delete(6L);
        findAll();
    }
}