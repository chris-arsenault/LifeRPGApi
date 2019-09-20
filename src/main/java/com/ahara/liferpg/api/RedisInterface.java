package com.ahara.liferpg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisInterface {

    @Autowired
    private LettuceConnectionFactory redisConnectionFactory;

    private RedisSerializer<String> serializer = new StringRedisSerializer();

    public String getWorldState() {
        var c = redisConnectionFactory.getConnection();
        return serializer.deserialize(c.get(serializer.serialize("World")));
    }
}
