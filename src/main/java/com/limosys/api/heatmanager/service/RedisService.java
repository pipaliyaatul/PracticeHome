package com.limosys.api.heatmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

	@Autowired
	RedisTemplate<String, Object> redisServer;
	
	
	public String hello() 
	{
		return "Redis Service Running";
	
	}
	
	public String firstfunc()
	{
		return "this is called from the firstfunction";
		
	}
	

}
