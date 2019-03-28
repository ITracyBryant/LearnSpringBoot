package io.itracybryant.learnspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SiteApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
        // 该方式存入redis的数据key-value都必须是String类型的 （需先toString String.valueOf() 转换）
        redisTemplate.boundValueOps("test1_key").set("test1_value_1");
        stringRedisTemplate.boundValueOps("test2_key").set("test2_value_2");
    }

}
