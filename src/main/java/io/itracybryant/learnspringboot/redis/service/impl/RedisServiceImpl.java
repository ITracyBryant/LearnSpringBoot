package io.itracybryant.learnspringboot.redis.service.impl;

import io.itracybryant.learnspringboot.redis.dto.RedisInfo;
import io.itracybryant.learnspringboot.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @ClassName RedisServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/10 15:12
 * @Version 1.0
 */
@Service
public class RedisServiceImpl implements RedisService {

    private static String redisCode = "utf-8";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 建立与redis的连接
     *
     * @return
     */
    private RedisConnection execute() {
        return redisTemplate.execute(new RedisCallback<RedisConnection>() {
            @Override
            public RedisConnection doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection;
            }
        });
    }

    private Map<String, Object> getData(String name, Object data) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("create_time", (new Date()).getTime());
        map.put(name, data);
        return map;
    }

    /**
     * 获取redis的基础信息Info
     *
     * @return
     */
    @Override
    public List<RedisInfo> getRedisInfo() {
        try {
            List<RedisInfo> list = new ArrayList<>();
            Properties info = execute().info();
            for (String key : info.stringPropertyNames()) {
                RedisInfo redisInfo = new RedisInfo();
                redisInfo.setKey(key);
                redisInfo.setValue(info.getProperty(key));
                list.add(redisInfo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * 获取redis内存占用信息
     *
     * @return
     */
    @Override
    public Map<String, Object> getRedisMemory() {
        return getData("memory", execute().info("memory").get("used_memory"));
    }

    /**
     * 获取redis key的数量
     *
     * @return
     */
    @Override
    public Map<String, Object> getRedisDbSize() {
        return getData("dbsize", execute().dbSize());
    }

    /**
     * 使用正则匹配来模糊查询Keys列表
     *
     * @param pattern
     * @return
     */
    @Override
    public Set<String> getKeys(String pattern) {
        try {
            return redisTemplate.keys(pattern);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    /**
     * 获取key的value
     *
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
        try {
            byte[] bytes = execute().get(key.getBytes());
            if (bytes != null) {
                return new String(bytes, redisCode);
            } else {
                return null;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加key-value对
     *
     * @param key
     * @param value
     * @return 是否成功添加
     */
    @Override
    public Boolean set(String key, String value) {
        return execute().set(key.getBytes(), value.getBytes());
    }

    /**
     * 删除key
     *
     * @param keys key数组
     * @return 成功删除的key个数
     */
    @Override
    public Long del(String... keys) {
        Long result = 0L;
        for (int i = 0; i < keys.length; i++) {
            result += execute().del(keys[i].getBytes());
        }
        return result;
    }

    /**
     * 判断key是否存在
     *
     * @param keys
     * @return 存在的key的个数
     */
    @Override
    public Long exist(String[] keys) {
        Long result = 0L;
        for (int i = 0; i < keys.length; i++) {
            if (execute().exists(keys[i].getBytes())) {
                result++;
            }
        }
        return result;
    }

    /**
     * 获取key的剩余过期时间
     *
     * @param key
     * @return 若key不存在，返回-2；
     * 若key存在但没设置过期时间，返回-1；
     * 否则，返回该key的剩余过期时间
     */
    @Override
    public Long pttl(String key) {
        return execute().pTtl(key.getBytes());
    }

    /**
     * 设置key的生成时间 (ms)
     *
     * @param key
     * @param time (ms)
     * @return 成功1，失败0
     */
    @Override
    public Long pexpire(String key, Long time) {
        if (execute().pExpire(key.getBytes(), time)) {
            return 1L;
        }
        return 0L;
    }
}
