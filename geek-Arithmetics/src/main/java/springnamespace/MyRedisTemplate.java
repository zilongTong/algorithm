package springnamespace;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ClassName MyRedisTemplate
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/8 19:45
 **/

public class MyRedisTemplate extends RedisTemplate<String,String> {
    public MyRedisTemplate() {
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        setKeySerializer(stringSerializer);
        setValueSerializer(stringSerializer);
        setHashKeySerializer(stringSerializer);
        setHashValueSerializer(stringSerializer);
    }

    public MyRedisTemplate(RedisConnectionFactory connectionFactory) {
        this();
        setConnectionFactory(connectionFactory);
        afterPropertiesSet();
    }

    public HashOperations opsForHash() {
        System.out.println("RedisTemplate opsForHash()....");
        return super.opsForHash();
    }
}
