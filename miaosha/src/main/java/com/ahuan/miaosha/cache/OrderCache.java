package com.ahuan.miaosha.cache;

import com.ahuan.miaosha.model.TOrder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/***
 * @ClassName OrderCache
 * @Description: OrderCache.java
 * @Author Ahuan
 * @Date 2020/4/16 
 * @Version V1.0
 **/
@Component
public class OrderCache extends RedisTemplate<String, TOrder> {

    public OrderCache(RedisConnectionFactory factory ){
        setConnectionFactory(factory);
        setKeySerializer(new StringRedisSerializer());
        setValueSerializer(new GenericJackson2JsonRedisSerializer());
        setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
        setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        afterPropertiesSet();
    }

    public  void setOrder(String key,TOrder order){
      this.opsForValue().set(key,order);
    }

    public TOrder getOrder(String key){
        TOrder order = this.opsForValue().get(key);
        return order;
    }
}