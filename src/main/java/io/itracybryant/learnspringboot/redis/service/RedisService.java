package io.itracybryant.learnspringboot.redis.service;



import io.itracybryant.learnspringboot.redis.dto.RedisInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @InterfaceName RedisService
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/10 14:44
 * @Version 1.0
 */
public interface RedisService {
    /**
     * 获取redis的基础信息Info
     * @return
     */
    List<RedisInfo> getRedisInfo();

    /**
     * 获取redis内存占用信息
     * @return
     */
    Map<String,Object> getRedisMemory();

    /**
     * 获取redis key的数量
     * @return
     */
    Map<String,Object> getRedisDbSize();

    /**
     * 使用正则匹配来模糊查询Keys列表
     * @param pattern
     * @return
     */
    Set<String> getKeys(String pattern);

    /**
     * 获取key的value
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 添加key-value对
     * @param key
     * @param value
     * @return 是否成功添加
     */
    Boolean set(String key, String value);

    /**
     * 删除key
     * @param keys key数组
     * @return 成功删除的key个数
     */
    Long del(String... keys);

    /**
     * 判断key是否存在
     * @param keys
     * @return 存在的key的个数
     */
    Long exist(String [] keys);

    /**
     * 获取key的剩余过期时间
     * @param key
     * @return 若key不存在，返回-2；
     *          若key存在但没设置过期时间，返回-1；
     *          否则，返回该key的剩余过期时间
     */
    Long pttl(String key);

    /**
     * 设置key的生成时间 (ms)
     * @param key
     * @param time (ms)
     * @return 设置成功的key个数
     */
    Long pexpire(String key, Long time);
}
