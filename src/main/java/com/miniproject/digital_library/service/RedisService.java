package com.miniproject.digital_library.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    //this is class provided by spring by which we can write & read the values
    private final StringRedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(String key, String value){
        this.redisTemplate.opsForValue().set(key,value,10, TimeUnit.MINUTES);
    }

    public Object get(String key){
        String value = this.redisTemplate.opsForValue().get(key);
        return value != null ? value : "Key not found";
    }
}
