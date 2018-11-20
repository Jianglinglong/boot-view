package com.jiang.demo.bootview.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author Jiang
 * @date 2018/11/20
 * @time 15:05
 */
@Repository
public class RedisOperator {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * key 是否存在
     *
     * @param key redis 键值 key
     * @return boolean  true 存在 false 不存在
     */
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 获取key的值
     * @param key redis 键值 key
     * @return Object 对应的值 若不存在 返回 null
     */
    public Object get(String key) {
        Object value = null;
        boolean exists = exists(key);
        if (exists) {
            ValueOperations<String, Object> forValue = redisTemplate.opsForValue();
            value = forValue.get(key);
        }
        return value;
    }

    /**
     * 存贮一个不过期的key
     * @param key  redis 键值 key
     * @param value 对应的值
     */
    public void set(String key, Object value) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
    }
    /**
     * 存贮一个key 过期时间为 timeout 秒
     * @param key  redis 键值 key
     * @param value 对应的值
     */
    public void set(String key,Object value,long timeout){
        set(key,value,timeout,TimeUnit.SECONDS);
    }
    /**
     * 存贮一个key 过期时间为 unit
     * @param key  redis 键值 key
     * @param value 对应的值
     */
    public void set(String key,Object value,long timeout, TimeUnit unit){
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value,timeout,unit);
    }

}
