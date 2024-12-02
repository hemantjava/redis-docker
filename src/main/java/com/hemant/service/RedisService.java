package com.hemant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void saveValue(String key, String value, long timeoutInSeconds) {
        redisTemplate.opsForValue().set(key, value, timeoutInSeconds, TimeUnit.SECONDS);
    }

    public String getValue(String key) {
        return getObject(key);
    }

    private String getObject(String key) {
        String rs = (String) redisTemplate.opsForValue().get(key);
        return Optional.ofNullable(rs).orElse("Value is not available in cache: " + key);
    }
}
