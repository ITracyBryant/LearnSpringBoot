package io.itracybryant.learnspringboot.redis.service.impl;

import io.itracybryant.learnspringboot.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisService redisService;

    @Test
    public void getKeys() {
        /*Set<String> keys = stringRedisTemplate.keys("*");
        logger.info("keys={}", keys);*/
        /*Set<String> keys = redisTemplate.keys("*");
        logger.info("keys = {}", keys);*/
        Set<String> keys = redisService.getKeys("*");
        logger.info("keys = {}", keys);
    }

    @Test
    public void get() {
        String key = redisService.get("new_key");
        logger.info("key = {}", key);
    }

    @Test
    public void set() {
        Boolean set = redisService.set("new_key", "new_value");
        logger.info("是否新增成功 = {}", set);
        getKeys();
    }

    @Test
    public void del() {
        redisService.set("key2", "value3");
        redisService.set("key3", "value3");
        String[] keys = {"key2", "key3"};
        Long count = redisService.del(keys);
        logger.info("删除的key个数 = {}", count);
        getKeys();
    }

    @Test
    public void exist() {
        String[] keys = {"new_key","test1_key"};
        Long exist = redisService.exist(keys);
        logger.info("存在的key个数 = {}", exist);
    }

    @Test
    public void pttl() {
        Long time = redisService.pttl("new_key");
        logger.info("该key-value剩余过期时间 = {}", time);
    }

    @Test
    public void pexpire() {
        Long result = redisService.pexpire("new_key", 1000000L);
        logger.info("设置key的生成时间是否成功 = {}", result);
        pttl();
    }
}