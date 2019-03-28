package io.itracybryant.learnspringboot.shiro.mapper;

import io.itracybryant.learnspringboot.shiro.entity.ShiroUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShiroUserMapperTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShiroUserMapper shiroUserMapper;

    @Test
    public void findByUsername() {
        ShiroUser shiroUser = shiroUserMapper.findByUsername("abc");
        logger.info("user={}", shiroUser);
    }
}